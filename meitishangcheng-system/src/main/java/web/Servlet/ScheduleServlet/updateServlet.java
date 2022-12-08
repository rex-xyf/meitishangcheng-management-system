package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Delete;
import pojo.Employee;
import pojo.Schedule;
import service.DeleteService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    ScheduleService scheduleService =new ScheduleService();
    DeleteService deleteService = new DeleteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("User");
        Schedule schedule = scheduleService.selectByName(user);
        Delete delete = deleteService.selectById(schedule.getId());
        String s = req.getReader().readLine();
        Employee employee = JSON.parseObject(s, Employee.class);
        if (delete == null){
            employee.setId(schedule.getId());
            deleteService.addInformation(employee);
            resp.getWriter().write("success");
        }else {
            deleteService.delete(schedule.getId());
            employee.setId(schedule.getId());
            deleteService.addInformation(employee);
            resp.getWriter().write("success");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
