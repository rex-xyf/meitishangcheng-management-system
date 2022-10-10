package web;

import utils.MailUtil;
import utils.createCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/userCheckCode")
public class userCheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = createCode.randomCode(5);
        String email = req.getParameter("email");
        MailUtil.sendMail(email,code);
        System.out.println(code);
        System.out.println("send successfully");
        HttpSession session = req.getSession();
        session.setAttribute("code",code);
        req.setAttribute("registerUsername",req.getParameter("username"));
        req.setAttribute("registerPassword",req.getParameter("password"));
        req.setAttribute("registerEmail",req.getParameter("email"));
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
