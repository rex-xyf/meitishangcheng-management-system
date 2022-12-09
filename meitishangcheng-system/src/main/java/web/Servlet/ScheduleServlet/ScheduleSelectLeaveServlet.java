package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Data;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/scheduleSelectLeaveServlet")
public class ScheduleSelectLeaveServlet extends HttpServlet {
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Data> datas = new ArrayList<>();
        boolean[] booleans = scheduleService.selectLeave();
        boolean[] leave ={true,false};
        for (boolean b : leave) {
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
