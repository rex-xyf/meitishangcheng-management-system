package web.Servlet.StockServlet;

import com.alibaba.fastjson.JSON;
import pojo.Stock;
import service.StockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stockSelectRequestServlet")
public class StockSelectRequestServlet extends HttpServlet {
    StockService stockService = new StockService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Stock> stocks = stockService.selectRequest();
        String jsonString = JSON.toJSONString(stocks);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
