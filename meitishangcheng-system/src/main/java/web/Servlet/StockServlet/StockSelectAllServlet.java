package web.Servlet.StockServlet;

import com.alibaba.fastjson.JSON;
import pojo.Stock;
import pojo.FormSelect;
import pojo.bean.StockBean;
import service.StockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stockSelectAllServlet")
public class StockSelectAllServlet extends HttpServlet {
    StockService StockService = new StockService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        FormSelect formSelect = JSON.parseObject(s, FormSelect.class);
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Stock> stocks = StockService.selectAll(currentPage,pageSize,formSelect.getKey(),"%"+formSelect.getValue()+"%");
        int count = StockService.count(formSelect.getKey(),"%"+formSelect.getValue()+"%");
        StockBean bean = new StockBean(stocks,count);
        String Bean = JSON.toJSONString(bean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(Bean);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
