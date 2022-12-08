package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Employee;
import pojo.FormSelect;
import pojo.Schedule;
import pojo.bean.EmployeeBean;
import pojo.bean.ScheduleBean;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/scheduleSelectAllServlet")
public class ScheduleSelectAllServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        FormSelect formSelect = JSON.parseObject(s, FormSelect.class);
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Schedule> schedules = scheduleService.selectAll(currentPage, pageSize, formSelect.getKey(), "%" + formSelect.getValue() + "%");
        int count = scheduleService.count(formSelect.getKey(),"%"+formSelect.getValue()+"%");
        ScheduleBean bean = new ScheduleBean(schedules,count);
        String Bean = JSON.toJSONString(bean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(Bean);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
