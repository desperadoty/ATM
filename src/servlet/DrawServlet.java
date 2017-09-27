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
 * Created by Administrator on 2017/3/3.
 */
@WebServlet(name = "DrawServlet",urlPatterns = "/servlet/DrawServlet")
public class DrawServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Account account = (Account) request.getSession().getAttribute("loginAccount"); //获取当前用户
        AccountDAO accountDAO = new AccountDAO();
        Transaction transaction = new Transaction();
        TransactionDAO transactionDAO = new TransactionDAO();
        String service = request.getParameter("service");
        String draw = ""; //记录取钱数额

        if(service.equals("n100")) {
            //用户点击取100元按钮
            draw = "100";
        } else if(service.equals("n500")) {
            //用户点击取500元按钮
            draw = "500";
        } else if(service.equals("n1000")) {
            //用户点击取1000元按钮
            draw = "1000";
        } else if(service.equals("n2500")) {
            //用户点击取2500元按钮
            draw = "2500";
        } else if(service.equals("n5000")) {
            //用户点击取5000元按钮
            draw = "5000";
        } else if(service.equals("n10000")) {
            //用户点击取10000元按钮
            draw = "10000";
        } else {
            //用户点击了确认按钮
            if(request.getParameter("draw") != null)
                draw = request.getParameter("draw");
        }

        //取钱必须取100的整数倍
        if(Double.valueOf(draw) % 100 != 0) {
            response.sendRedirect(request.getContextPath() + "/wrongAmount.jsp");
        }

        request.getSession().setAttribute("draw",draw);
        transaction.setId(account.getId());
        transaction.setTranstype("draw");
        transaction.setAmount(Double.parseDouble(draw));

        if(!response.isCommitted()) {
            if (accountDAO.drawMoney(account, draw) && transactionDAO.addDrawInfo(transaction)) {
                response.sendRedirect(request.getContextPath() + "/draw_ok.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/insufficient.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
