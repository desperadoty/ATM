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
 * 检测卡号，是否存在该账户
 */
@WebServlet(name = "CheckServlet",urlPatterns = "/servlet/CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = new Account();
        AccountDAO accountDAO = new AccountDAO();

        String id = "";
        if(request.getParameter("id") != null && !"".equals((request.getParameter("id").trim()))) {
            id = request.getParameter("id");
        }

        account.setId(id);
        request.getSession().setAttribute("loginAccount",account);

        if(accountDAO.checkAccount(account)) {
            response.sendRedirect(request.getContextPath()+"/check_ok.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/check_fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
