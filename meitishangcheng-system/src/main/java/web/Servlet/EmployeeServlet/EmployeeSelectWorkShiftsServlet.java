package web.Servlet.EmployeeServlet;

import com.alibaba.fastjson.JSON;
import pojo.Data;
import pojo.Department;
import service.DepartmentService;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/employeeSelectWorkShiftsServlet")
public class EmployeeSelectWorkShiftsServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Data> datas = new ArrayList<>();
        String[] strings = employeeService.selectWorkShifts();
        String[] workShifts ={"morning","afternoon","evening"};
        for (String str :workShifts) {
            int sum = 0;
            for (String s :strings) {
                if (str.equals (s)) {
                    sum++;
                }
            }
            Data data = new Data();
            data.setName(str);
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
