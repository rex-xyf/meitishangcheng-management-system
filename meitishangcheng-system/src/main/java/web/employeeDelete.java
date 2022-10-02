package web;

import service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/employeeDelete")
public class employeeDelete extends HttpServlet {
    employeeService employeeService = new employeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("0");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("1");
        employeeService.delete(id);
        System.out.println("2");
        resp.sendRedirect("/meitishangcheng-system/employeeSelectAll");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
