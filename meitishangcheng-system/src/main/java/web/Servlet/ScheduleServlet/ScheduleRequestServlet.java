package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Schedule;
import pojo.bean.ScheduleRequestBean;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/scheduleRequestServlet")
public class ScheduleRequestServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Schedule> schedules = scheduleService.selectRequest();
        List<ScheduleRequestBean> beans = new ArrayList<>();
        for (Schedule schedule : schedules){
            ScheduleRequestBean scheduleRequestBean = new ScheduleRequestBean(schedule.getId(),schedule.getName(),schedule.getState()-10);
            beans.add(scheduleRequestBean);
        }
        String jsonString = JSON.toJSONString(beans);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
