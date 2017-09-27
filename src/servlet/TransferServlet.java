package servlet;

import com.po.Account;
import com.po.Transfer;
import dao.AccountDAO;
import dao.TransferDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/4.
 */
@WebServlet(name = "TransferServlet",urlPatterns = "/servlet/TransferServlet")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account1 = (Account) request.getSession().getAttribute("loginAccount");
        AccountDAO accountDAO = new AccountDAO();
        Transfer transfer = new Transfer();
        TransferDAO transferDAO = new TransferDAO();
        String transferin = ""; // 转账账户
        double money = 0.0; //转账金额
        String service = request.getParameter("service");

        //转账涉及的两个账户
        if(request.getSession().getAttribute("transferin") != null) {
            transferin = (String) request.getSession().getAttribute("transferin");
            transfer.setTransferin(transferin);
            transfer.setTransferout(account1.getId());
        }


        if(service.equals("n100")) {
            //用户转账100元
            money = 100d;
        } else if(service.equals("n500")) {
            //用户转账500元
            money = 500d;
        } else if(service.equals("n1000")) {
            //用户转账1000元
            money = 1000d;
        } else if(service.equals("n2500")) {
            //用户转账2500元
            money = 2500d;
        } else if(service.equals("n5000")) {
            //用户转账5000元
            money = 5000d;
        } else if(service.equals("n10000")) {
            //用户转账10000元
            money = 10000d;
        } else {
            if(request.getParameter("money") != null)
                 money = Double.parseDouble(request.getParameter("money"));
        }

        request.getSession().setAttribute("transfer",String.valueOf(money));


        transfer.setAmount(money);
        Account account2 = accountDAO.inquireById(transferin);

        if(!response.isCommitted()) {
            if (accountDAO.transferMoney(account1, account2, money) && transferDAO.addTransferInfo(transfer)) {
                response.sendRedirect(request.getContextPath() + "/transfer_ok.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/insufficient.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
