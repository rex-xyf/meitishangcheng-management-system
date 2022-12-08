package web.Servlet.StockServlet;

import pojo.Stock;
import service.StockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stockAgreeServlet")
public class StockAgreeServlet extends HttpServlet {
    StockService stockService = new StockService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getReader().readLine());
        Stock stock = stockService.selectById(id);
        int amount = stock.getAmount();
        int purchase = stock.getPurchase();
        int change = amount+purchase;
        stockService.renew(id,change,0);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
