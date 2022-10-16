package web;

import pojo.Manager;
import service.ManagerService;
import utils.CreateCode;
import utils.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/userFindCode")
public class UserFindCode extends HttpServlet {
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        Manager manager = new Manager(0,username,null,true,email);
        Manager manager1 = managerService.selectByEmail(manager);
        if (manager1!=null){
            String code = CreateCode.randomCode(5);
            MailUtil.sendMail(email,code);
            HttpSession session = req.getSession();
            session.setAttribute("findCode",code);
            session.setAttribute("manager",manager1);
            req.setAttribute("forgetUsername",username);
            req.setAttribute("forgetEmail",email);
            req.getRequestDispatcher("forget.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("findFell","Username and email do not match");
            req.getRequestDispatcher("forget.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
