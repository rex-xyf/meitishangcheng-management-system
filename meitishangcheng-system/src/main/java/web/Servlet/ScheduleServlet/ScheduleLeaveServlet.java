package web.Servlet.ScheduleServlet;

import pojo.Schedule;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scheduleLeaveServlet")
public class ScheduleLeaveServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("user");
        int i = Integer.parseInt(req.getParameter("number"));
        int state = i+10;
        Schedule schedule = scheduleService.selectByName(s);
        scheduleService.updateState(schedule.getId(),state);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
