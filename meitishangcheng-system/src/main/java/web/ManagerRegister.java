package web;
import pojo.Manager;
import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/managerRegister")
public class ManagerRegister extends HttpServlet {
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Manager select = managerService.selectOne(username);
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        String code1 = req.getParameter("code");
        System.out.println(code);
        System.out.println(code1);
        if (code == null) {
            req.setAttribute("registerFell", "Please click to send verification code");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            if (code.equals(code1)) {
                if (select != null) {
                    req.setAttribute("registerFell", "The user name has been registered");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                } else {
                    Manager manager = new Manager(0, username, password, true, email);
                    managerService.add(manager);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("registerFell", "Incorrect input of verification code");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
