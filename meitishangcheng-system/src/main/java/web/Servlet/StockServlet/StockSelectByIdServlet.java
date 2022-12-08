package web.Servlet.StockServlet;

import com.alibaba.fastjson.JSON;
import pojo.Stock;
import service.StockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/stockSelectByIdServlet")
public class StockSelectByIdServlet extends HttpServlet {
    StockService StockService = new StockService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        int s = Integer.parseInt(reader.readLine());
        Stock Stock = StockService.selectById(s);
        String jsonString = JSON.toJSONString(Stock);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
