package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Stock;

import java.util.List;

public interface StockMapper {
    List<Stock> selectAll(@Param("begin") int begin, @Param("size") int size, @Param("key") String key, @Param("value") String value);

    void add(Stock stock);

    void delete(int id);

    void update(Stock stock);

    Stock selectById(int id);

    void deleteByIds(@Param("ids") int[] ids);

    int count(@Param("key") String key, @Param("value") String value);

    void updateNumber (@Param("id") int id , @Param("num") int num);

    int requestCount();

    List<Stock> selectRequest();

    void renew (@Param("id") int id , @Param("amount") int amount,@Param("purchase") int purchase);
}
