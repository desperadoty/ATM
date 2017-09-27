package servlet;

import com.po.Account;
import com.po.Transaction;
import dao.AccountDAO;
import dao.TransactionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/4.
 * deposit存款
 */
@WebServlet(name = "DepositServlet",urlPatterns = "/servlet/DepositServlet")
public class DepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("loginAccount");
        AccountDAO accountDAO = new AccountDAO();
        Transaction transaction = new Transaction();
        TransactionDAO transactionDAO = new TransactionDAO();

        String deposit = "";



        if(request.getParameter("deposit") != null) {
            deposit = request.getParameter("deposit");
            //存钱必须存100的整数倍
            if(Double.valueOf(deposit) % 100 != 0) {
                response.sendRedirect(request.getContextPath() + "/wrongAmount.jsp");
            }
            request.getSession().setAttribute("deposit",deposit);
            transaction.setId(account.getId());
            transaction.setTranstype("deposit");
            transaction.setAmount(Double.parseDouble(deposit));
        }

        if(!response.isCommitted()) {
            if (accountDAO.depositMoney(account, deposit) && transactionDAO.addDepositInfo(transaction)) {
                response.sendRedirect(request.getContextPath() + "/deposit_check.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
