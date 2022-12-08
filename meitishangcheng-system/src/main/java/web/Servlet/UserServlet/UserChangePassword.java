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
import java.io.IOException;
@WebServlet("/userChangePassword")
public class UserChangePassword extends HttpServlet {
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            int id = (int) session.getAttribute("forget");
            String s = req.getReader().readLine();
            Manager manager = new Manager(id, null, s, false, null);
            managerService.updatePassword(manager);
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
