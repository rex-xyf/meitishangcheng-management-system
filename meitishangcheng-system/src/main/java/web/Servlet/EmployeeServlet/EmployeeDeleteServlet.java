package web.Servlet.EmployeeServlet;

import pojo.Employee;
import service.DeleteService;
import service.EmployeeService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/employeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    DeleteService deleteService = new DeleteService();
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        int s = Integer.parseInt(reader.readLine());
        Employee employee = employeeService.selectById(s);
        deleteService.add(employee);
        employeeService.delete(s);
        scheduleService.updateState(s,2);
        resp.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
