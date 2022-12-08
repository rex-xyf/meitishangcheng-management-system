package web.Servlet.UserServlet;

import pojo.Employee;
import pojo.Schedule;
import service.EmployeeService;
import service.ManagerService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userSelectStock")
public class UserSelectStock extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        System.out.println(s);
        Schedule schedule = scheduleService.selectByName(s);
        System.out.println(schedule);
        Employee employee = employeeService.selectById(schedule.getId());
        System.out.println(employee);
        if (employee.getDepartment().equals("stock")){
            resp.getWriter().write("yes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
