package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll();

    void add(Employee Employee);

    Employee selectById(int id);

    void update(Employee Employee);

    void delete(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
