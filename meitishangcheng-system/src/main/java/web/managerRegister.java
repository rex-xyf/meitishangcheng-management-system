package web;
import pojo.manager;
import service.managerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/managerRegister")
public class managerRegister extends HttpServlet {
    managerService managerService = new managerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        manager select = managerService.selectOne(username);
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        String code1 = req.getParameter("code");
        System.out.println(code);
        System.out.println(code1);
        if (code.equals(code1)) {
            if (select != null) {
                req.setAttribute("registerFell", "该用户名已被注册");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } else {
                manager manager = new manager(0,username, password,true,email);
                managerService.add(manager);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
        else{
            req.setAttribute("registerFell","验证码输入有误");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
