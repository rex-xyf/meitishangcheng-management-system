package service;

import mapper.StockMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Stock;
import utils.GetSqlSessionFactory;

import java.util.List;

public class StockService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();
    public List<Stock> selectAll(int currentPage, int pageSize, String key, String value){
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        List<Stock> stocks = mapper.selectAll(begin,size,key,value);
        sqlSession.close();
        return stocks;
    }

    public void add(Stock stock) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.add(stock);
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.delete(id);
        sqlSession.close();
    }

    public void update(Stock stock){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.update(stock);
        sqlSession.close();
    }

    public void updateNumber(int id , int num){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.updateNumber(id,num);
        sqlSession.close();
    }

    public Stock selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        Stock Stock = mapper.selectById(id);
        sqlSession.close();
        return Stock;
    }

    public void deleteByIds (int[] ids){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.close();
    }

    public int count(String key,String value){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        int count = mapper.count(key,value);
        sqlSession.close();
        return count;
    }

    public int requestCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        int count = mapper.requestCount();
        sqlSession.close();
        return count;
    }

    public List<Stock> selectRequest(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        List<Stock> stocks = mapper.selectRequest();
        sqlSession.close();
        return stocks;
    }

    public void renew(int id,int amount,int purchase){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StockMapper mapper = sqlSession.getMapper(StockMapper.class);
        mapper.renew(id,amount,purchase);
        sqlSession.close();
    }
}
