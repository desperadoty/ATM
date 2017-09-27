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
 * Created by Administrator on 2017/3/3.
 */
@WebServlet(name = "ServiceServlet",urlPatterns = "/servlet/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        AccountDAO accountDAO = new AccountDAO();
        Account account = (Account) request.getSession().getAttribute("loginAccount");
        account.setBalance(accountDAO.Inquire(account));

        String btnType = request.getParameter("btnType");
        if(btnType.equals("inquire")) {
            //用户点击了查询按钮
            response.sendRedirect(request.getContextPath() + "/inquire.jsp");
        } else if(btnType.equals("draw")) {
            //用户点击了取款按钮
            response.sendRedirect(request.getContextPath() + "/draw.jsp");
        } else if(btnType.equals("transfer")) {
            //用户点击了转账按钮
            response.sendRedirect(request.getContextPath() + "/transfer.jsp");
        } else if(btnType.equals("deposit")) {
            //用户点击了存款按钮
            response.sendRedirect(request.getContextPath() + "/deposit.jsp");
        } else if(btnType.equals("changepassword")) {
            //用户点击了修改密码按钮
            response.sendRedirect(request.getContextPath()+"/oriPass.jsp");
        }else if(btnType.equals("inquireAfterDraw")) {
            //用户取款后查询余额
            account.setBalance(accountDAO.Inquire(account));
            response.sendRedirect(request.getContextPath() + "/inquireAfterDraw.jsp");
        } else if(btnType.equals("inquireAfterDeposit")) {
            //用户存款后查询余额
            account.setBalance(accountDAO.Inquire(account));
            response.sendRedirect(request.getContextPath() + "/inquireAfterDeposit.jsp");
        }else {
            //用户点击了退卡按钮
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
