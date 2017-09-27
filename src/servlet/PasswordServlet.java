package servlet;

import com.po.Account;
import dao.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/4.
 */
@WebServlet(name = "PasswordServlet",urlPatterns = "/servlet/PasswordServlet")
public class PasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO accountDAO = new AccountDAO();
        Account account = (Account) request.getSession().getAttribute("loginAccount");
        String newPass =(String) request.getSession().getAttribute("newPass");
        String newPsw = "";
        if(request.getParameter("newPsw") != null) {
            newPsw = request.getParameter("newPsw");
        }
        //判断两次输入的新密码是否一致
        if(newPsw.equals(newPass)) {
            if (accountDAO.changePassword(account, newPsw)) {
                account.setPassword(newPsw);
                response.sendRedirect(request.getContextPath() + "/relog.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/wrongNewPass.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
