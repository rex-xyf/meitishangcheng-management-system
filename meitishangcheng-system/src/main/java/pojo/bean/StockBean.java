package pojo.bean;

import pojo.Stock;

import java.util.List;

public class StockBean {
    private List<Stock> stocks;
    private int count;

    public StockBean() {
    }

    public StockBean(List<Stock> stocks, int count) {
        this.stocks = stocks;
        this.count = count;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "StockBean{" +
                "stocks=" + stocks +
                ", count=" + count +
                '}';
    }
}
