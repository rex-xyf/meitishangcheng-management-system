package web.Servlet.UserServlet;

import utils.MailUtil;
import utils.CreateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/userCheckCode")
public class UserCheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getReader().readLine();
            String code = CreateCode.randomCode(5);
            MailUtil.sendMail(email, code);
            resp.getWriter().write(code);
        }catch (Exception e){
            resp.getWriter().write("error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
