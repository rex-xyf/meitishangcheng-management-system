package web;

import pojo.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/employeeUpdate")
public class EmployeeUpdate extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String hourWages = req.getParameter("hourWages");
        String department = req.getParameter("department");
        String workShifts = req.getParameter("workShifts");
        Employee employee = new Employee(id,name,address,hourWages,department,workShifts);
        employeeService.update(employee);
        resp.sendRedirect("/meitishangcheng-system/employeeSelectLimit?page="+req.getParameter("page"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
