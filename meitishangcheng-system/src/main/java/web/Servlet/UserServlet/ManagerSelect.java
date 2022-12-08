package web.Servlet.UserServlet;

import com.alibaba.fastjson.JSON;
import pojo.Employee;
import pojo.Manager;
import pojo.Schedule;
import service.EmployeeService;
import service.ManagerService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/managerSelect")
public class ManagerSelect extends HttpServlet {
    ManagerService managerService = new ManagerService();
    EmployeeService employeeService = new EmployeeService();
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        Manager manager1 = JSON.parseObject(s, Manager.class);
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        Manager manager1 = new Manager(0, username, password, true, null);
        Manager manager = managerService.select(manager1);
        HttpSession session = req.getSession();
        String loginCheckCode = (String) session.getAttribute("loginCheckCode");
        String code = req.getParameter("code");
        Boolean remember = Boolean.valueOf(req.getParameter("remember"));
        if (loginCheckCode.equals(code)) {
            if (manager != null) {
                if (remember) {
                    Cookie cookie1 = new Cookie("username", manager1.getUsername());
                    Cookie cookie2 = new Cookie("password", manager1.getPassword());
                    cookie1.setMaxAge(60 * 60 * 24 * 7);
                    cookie2.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);
                } else {
                    Cookie cookie3 = new Cookie("username",null);
                    Cookie cookie4 = new Cookie("password",null);
                    cookie3.setMaxAge(60 * 60 * 24 * 7);
                    cookie4.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cookie3);
                    resp.addCookie(cookie4);
                }
//                session.setAttribute("manager", manager);
//                //req.setAttribute("user",user.getUsername());
//                req.getRequestDispatcher("/employeeSelectLimit?page=1").forward(req, resp);
                Cookie cookie = new Cookie("isLogin",manager1.getUsername());
                resp.addCookie(cookie);
                if (manager.isPermission()){
                    resp.getWriter().write("manager");
                }else {
                    try {
                        Schedule schedule = scheduleService.selectByName(manager1.getUsername());
                        Employee employee = employeeService.selectById(schedule.getId());
                        if (Objects.equals(employee.getDepartment(), "stock")) {
                            Cookie cookie1 = new Cookie("isManager", "true");
                            resp.addCookie(cookie1);
                        }
                        else {
                            Cookie cookie1 = new Cookie("isManager", "false");
                            resp.addCookie(cookie1);
                        }
                        resp.getWriter().write("employee");
                    }catch (Exception e){
                        Cookie cookie1 = new Cookie("isManager", "false");
                        resp.addCookie(cookie1);
                        resp.getWriter().write("employee");
                    }
                }
            } else {
//                req.setAttribute("fell", "Username or password error");
//                req.getRequestDispatcher("login.html").forward(req, resp);
                resp.getWriter().write("fell");
            }

        }
        else {
//            req.setAttribute("fell", "CAPTCHA error");
//            req.getRequestDispatcher("login.html").forward(req, resp);
            resp.getWriter().write("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
