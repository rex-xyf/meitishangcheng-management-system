package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll(@Param("begin") int begin, @Param("size") int size, @Param("key") String key, @Param("value") String value);

    void add(Employee employee);

    void delete(int id);

    void update(Employee employee);

    Employee selectById(int id);

    void deleteByIds(@Param("ids") int[] ids);

    List<Employee> selectByIds(@Param("ids") int[] ids);

    int count(@Param("key") String key, @Param("value") String value);

    void addId(Employee employee);
}
