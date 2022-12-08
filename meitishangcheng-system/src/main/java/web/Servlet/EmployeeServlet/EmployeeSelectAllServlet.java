package web.Servlet.EmployeeServlet;

import com.alibaba.fastjson.JSON;
import pojo.Employee;
import pojo.bean.EmployeeBean;
import pojo.FormSelect;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeeSelectAllServlet")
public class EmployeeSelectAllServlet extends HttpServlet {
    EmployeeService EmployeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        FormSelect formSelect = JSON.parseObject(s, FormSelect.class);
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Employee> employees = EmployeeService.selectAll(currentPage,pageSize,formSelect.getKey(),"%"+formSelect.getValue()+"%");
        int count = EmployeeService.count(formSelect.getKey(),"%"+formSelect.getValue()+"%");
        EmployeeBean bean = new EmployeeBean(employees,count);
        String Bean = JSON.toJSONString(bean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(Bean);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
