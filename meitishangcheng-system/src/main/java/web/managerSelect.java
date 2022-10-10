package web;

import pojo.manager;
import service.managerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/managerSelect")
public class managerSelect extends HttpServlet {
    managerService managerService = new managerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        manager manager1 = new manager(0,username,password,true,null);
        manager manager = managerService.select(manager1);
        if (manager != null) {
            if (req.getParameter("remember") != null) {
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                cookie1.setMaxAge(60*60*24*7);
                cookie2.setMaxAge(60*60*24*7);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
            else {
                Cookie cookie3 = new Cookie("username", null);
                Cookie cookie4 = new Cookie("password", null);
                cookie3.setMaxAge(60*60*24*7);
                cookie4.setMaxAge(60*60*24*7);
                resp.addCookie(cookie3);
                resp.addCookie(cookie4);
            }
            HttpSession session = req.getSession();
            session.setAttribute("manager", manager);
            //req.setAttribute("user",user.getUsername());
            req.getRequestDispatcher("/employeeSelectAll").forward(req, resp);

        }
        else {
            req.setAttribute("fell","Username or password error");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
