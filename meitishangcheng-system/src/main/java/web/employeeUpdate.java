package web;

import pojo.employee;
import service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/employeeUpdate")
public class employeeUpdate extends HttpServlet {
    employeeService employeeService = new employeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String hourWages = req.getParameter("hourWages");
        String department = req.getParameter("department");
        String workShifts = req.getParameter("workShifts");
        employee employee = new employee(id,name,address,hourWages,department,workShifts);
        employeeService.update(employee);
        resp.sendRedirect("/meitishangcheng-system/employeeSelectAll");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
