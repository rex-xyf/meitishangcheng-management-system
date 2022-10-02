package mapper;

import pojo.employee;

import java.util.List;

public interface employeeMapper {
    List<employee> selectAll();

    void add(employee Employee);

    employee selectById(int id);

    void update(employee Employee);

    void delete(int id);
}
