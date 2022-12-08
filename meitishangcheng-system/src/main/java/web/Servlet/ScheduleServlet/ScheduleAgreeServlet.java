package web.Servlet.ScheduleServlet;

import pojo.Schedule;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scheduleAgreeServlet")
public class ScheduleAgreeServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getReader().readLine());
        Schedule schedule = scheduleService.selectById(id);
        int state = schedule.getState();
        int daysOff = state-10;
        scheduleService.update(id,true,daysOff);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
