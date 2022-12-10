package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Schedule;
import pojo.bean.DateBean;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/scheduleSelectClockInServlet")
public class ScheduleSelectClockInServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        Schedule schedule = scheduleService.selectByName(s);
        if (!schedule.getAttendance()){
            DateBean dateBean = new DateBean();
            String s1 = JSON.toJSONString(dateBean);
            resp.getWriter().write(s1);
        }else if (schedule.getAttendance()){
            SimpleDateFormat dateFormat  =new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateNow = new java.util.Date();
            String format = dateFormat.format(dateNow);
            DateBean dateBean =new DateBean(format,"yes");
            List<DateBean> dateBeans = new ArrayList<>();
            dateBeans.add(dateBean);
            String s1 = JSON.toJSONString(dateBeans);
            System.out.println(s1);
            System.out.println("select.....");
            resp.getWriter().write(s1);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
