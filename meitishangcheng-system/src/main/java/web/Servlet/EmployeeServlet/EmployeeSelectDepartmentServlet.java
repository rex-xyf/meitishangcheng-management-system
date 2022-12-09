package web.Servlet.EmployeeServlet;

import com.alibaba.fastjson.JSON;
import pojo.Data;
import pojo.Department;
import pojo.FormSelect;
import service.DepartmentService;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/employeeSelectDepartmentServlet")
public class EmployeeSelectDepartmentServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    DepartmentService departmentService = new DepartmentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Data> datas = new ArrayList<>();
        String[] strings = employeeService.selectDepartment();
        List<Department> departments = departmentService.selectAll();
        for (Department department:departments) {
            int sum = 0;
            for (String s :strings) {
                if (department.getText().equals (s)) {
                    sum++;
                }
            }
            Data data = new Data();
            data.setName(department.getText());
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
