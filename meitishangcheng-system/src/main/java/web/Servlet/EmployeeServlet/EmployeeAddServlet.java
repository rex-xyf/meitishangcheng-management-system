package web.Servlet.EmployeeServlet;

import com.alibaba.fastjson.JSON;
import pojo.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/employeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
    EmployeeService EmployeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        Employee employee = JSON.parseObject(s, Employee.class);
        if (employee.getWorkShifts()!="morning"||employee.getWorkShifts()!="afternoon"||employee.getWorkShifts()!="evening") {
            String[] str = {"morning", "afternoon", "evening"};
            int random = (int) (Math.random() * 3);
            employee.setWorkShifts(str[random]);
        }
        EmployeeService.add(employee);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
