package web.Servlet.UserServlet;
import com.alibaba.fastjson.JSON;
import pojo.Manager;
import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/managerRegister")
public class ManagerRegister extends HttpServlet {
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BufferedReader reader = req.getReader();
            String s = reader.readLine();
            Manager manager = JSON.parseObject(s, Manager.class);
            Boolean power = Boolean.valueOf(req.getParameter("power"));
            if (power) {
                manager.setPermission(true);
            } else {
                manager.setPermission(false);
            }
            managerService.add(manager);
            resp.getWriter().write("success");
        }catch (Exception e){
            resp.getWriter().write("error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
