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
 * Created by Administrator on 2017/3/2.
 * 检测密码，是否与账户匹配
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO accountDAO = new AccountDAO();
        Account account = (Account) request.getSession().getAttribute("loginAccount");
        String password = "";
        String oriPass = "";
        if(request.getParameter("password") != null) {
            password = request.getParameter("password");
            account.setPassword(password);
            if(accountDAO.CheckLogin(account)) {
                response.sendRedirect(request.getContextPath() + "/login_ok.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/login_fail.jsp");
            }
        }

        //用户选择了修改密码服务
        if(request.getParameter("oriPass") != null) {
            oriPass = request.getParameter("oriPass");
            account.setPassword(oriPass);
            if(accountDAO.CheckLogin(account)) {
                response.sendRedirect(request.getContextPath() + "/newPass.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/wrongOriPass.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
