package web;

import pojo.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeeSelect")
public class EmployeeSelect extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String key = req.getParameter("selected");
        String value = req.getParameter("text");
        System.out.println(key);
        System.out.println(value);
        List<Employee> employees = employeeService.select(key, value);
        System.out.println(employees);
        switch (key){
            case "name":
                req.setAttribute("selectName","selected");
                break;
            case "address":
                req.setAttribute("selectAddress","selected");
                break;
            case "hourWages":
                req.setAttribute("selectHourWages","selected");
                break;
            case "department":
                req.setAttribute("selectDepartment","selected");
                break;
            case "workShifts":
                req.setAttribute("selectWorkShifts","selected");
                break;
        }
        req.setAttribute("text",value);
        req.setAttribute("employee",employees);
        req.getRequestDispatcher("/employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
