package web.Servlet.DeleteServlet;

import com.alibaba.fastjson.JSON;
import pojo.Delete;
import service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteSelectAllServlet")
public class DeleteSelectAllServlet extends HttpServlet {
    DeleteService deleteService = new DeleteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Delete> deletes = deleteService.selectAll();
        String jsonString = JSON.toJSONString(deletes);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
