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

@WebServlet("/stockUpdateServlet")
public class StockUpdateServlet extends HttpServlet {
    StockService stockService =new StockService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        Stock Stock = JSON.parseObject(s, Stock.class);
        stockService.update(Stock);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
