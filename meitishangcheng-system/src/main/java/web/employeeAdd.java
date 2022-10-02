package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import pojo.employee;
import service.employeeService;

@WebServlet("/employeeAdd")
public class employeeAdd extends HttpServlet {
    employeeService employeeService = new employeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String hourWages = req.getParameter("hourWages");
        String department = req.getParameter("department");
        String workShifts = req.getParameter("workShifts");
        employee employee1 =new employee(0,name,address,hourWages,department,workShifts);
        employeeService.add(employee1);
//        req.getRequestDispatcher("/employeeSelectAll").forward(req,resp);
        resp.sendRedirect("/meitishangcheng-system/employeeSelectAll");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
