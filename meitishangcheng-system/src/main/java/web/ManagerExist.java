package web;

import pojo.Manager;
import service.ManagerService;
import utils.SendPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/managerExist")
public class ManagerExist extends HttpServlet {
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String findCode = (String) session.getAttribute("findCode");
        Manager manager = (Manager) session.getAttribute("manager");
        if (code.equals(findCode)){
                SendPassword.sendMail(manager.getEmail(),manager.getPassword());
                req.getRequestDispatcher("forget.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("findFell","Email verification code error");
                req.getRequestDispatcher("forget.jsp").forward(req,resp);
            }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
