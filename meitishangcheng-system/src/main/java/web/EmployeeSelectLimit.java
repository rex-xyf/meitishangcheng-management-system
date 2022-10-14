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

@WebServlet("/employeeSelectLimit")
public class EmployeeSelectLimit extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int begin = (Integer.parseInt(req.getParameter("page"))-1)*7;
        int size = 7;
        List<Employee> employees = employeeService.selectLimit(begin, size);
        int count = employeeService.selectCount();
        req.setAttribute("messageCount",count);
        req.setAttribute("employee",employees);
        req.setAttribute("currentPage",req.getParameter("page"));
        if(count%7==0){
            int totalPage = count/7;
            req.setAttribute("totalPage",totalPage);
        }
        else {
            int totalPage = (count/7)+1;
            req.setAttribute("totalPage",totalPage);
        }
        req.getRequestDispatcher("employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
