package web.Servlet.ScheduleServlet;

import com.alibaba.fastjson.JSON;
import pojo.Employee;
import pojo.Manager;
import pojo.Schedule;
import pojo.bean.EmployeeInformationBean;
import service.EmployeeService;
import service.ManagerService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/selectByNameServlet")
public class SelectByNameServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    ScheduleService scheduleService = new ScheduleService();
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s1 = req.getReader().readLine();
        String s = JSON.parseObject(s1,String.class);
        Schedule schedule = scheduleService.selectByName(s);
        if (schedule == null){
            Schedule schedule1 = new Schedule(0,null,s,false,false,0,0);
            scheduleService.add(schedule1);
            Schedule schedule2 = scheduleService.selectByName(s);
            System.out.println(schedule2);
            Employee employee =new Employee();
            employee.setId(schedule2.getId());
            System.out.println(employee);
            employeeService.addId(employee);
            Manager manager = managerService.selectOne(s);
            EmployeeInformationBean bean = new EmployeeInformationBean(employee,manager.getEmail());
            String jsonString = JSON.toJSONString(bean);
            resp.getWriter().write(jsonString);
        }else{
            Employee employee = employeeService.selectById(schedule.getId());
            Manager manager = managerService.selectOne(s);
            EmployeeInformationBean bean = new EmployeeInformationBean(employee,manager.getEmail());
            String jsonString = JSON.toJSONString(bean);
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
