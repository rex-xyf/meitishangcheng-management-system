package web;

import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/employeeDeleteByIds")
public class EmployeeDeleteByIds extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selects = req.getParameterValues("select");
        int[] ids = new int[selects.length];
        for (int i = 0; i < selects.length; i++) {
            ids[i] = Integer.parseInt(selects[i]);
        }
        employeeService.deleteByIds(ids);
        resp.sendRedirect("/meitishangcheng-system/employeeSelectAll");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
