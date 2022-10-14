package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import pojo.Employee;
import service.EmployeeService;

@WebServlet("/employeeAdd")
public class EmployeeAdd extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String hourWages = req.getParameter("hourWages");
        String department = req.getParameter("department");
        String workShifts = req.getParameter("workShifts");
        Employee employee1 =new Employee(0,name,address,hourWages,department,workShifts);
        employeeService.add(employee1);
//        req.getRequestDispatcher("/employeeSelectAll").forward(req,resp);
        resp.sendRedirect("/meitishangcheng-system/employeeSelectLimit?page="+req.getParameter("page"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
