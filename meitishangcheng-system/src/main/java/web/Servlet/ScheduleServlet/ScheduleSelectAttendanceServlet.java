package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Data;
import service.EmployeeService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/scheduleSelectAttendanceServlet")
public class ScheduleSelectAttendanceServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Data> datas = new ArrayList<>();
        boolean[] booleans = scheduleService.selectAttendance();
        boolean[] attendance ={true,false};
        for (boolean b : attendance) {
            int sum = 0;
            for (boolean s :booleans) {
                if (b==s) {
                    sum++;
                }
            }
            Data data = new Data();
            data.setName(String.valueOf(b));
            data.setValue(String.valueOf(sum));
            datas.add(data);
        }
        String string = JSON.toJSONString(datas);
        resp.getWriter().write(string);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
