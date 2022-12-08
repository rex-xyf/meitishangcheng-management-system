package web.Servlet.UserServlet;

import com.alibaba.fastjson.JSON;
import pojo.Manager;
import service.ManagerService;
import utils.CreateCode;
import utils.FindPassword;
import utils.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/userFindCode")
public class UserFindCode extends HttpServlet {
    ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String s = req.getReader().readLine();
            Manager manager = JSON.parseObject(s, Manager.class);
            Manager manager1 = managerService.find(manager);
            if (manager1 != null) {
                HttpSession session = req.getSession();
                session.setAttribute("forget",manager1.getId());
                String code = CreateCode.randomCode(5);
                FindPassword.sendMail(manager1.getEmail(),code);
                Cookie cookie = new Cookie("checkCode",code);
                resp.addCookie(cookie);
                resp.getWriter().write("success");
            } else {
                resp.getWriter().write("error");
            }
        }catch (Exception e){
            resp.getWriter().write("unknown false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
