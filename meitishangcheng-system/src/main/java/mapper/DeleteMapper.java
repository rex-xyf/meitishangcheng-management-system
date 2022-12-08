package mapper;

import pojo.Delete;
import pojo.Employee;

import java.util.List;

public interface DeleteMapper {
    void add(Employee employee);

    void addInformation(Employee employee);

    void delete(int id);

    List<Delete> selectAll();

    Delete selectById(int id);

    int count();

    List<Delete> selectAllByState();

    int modifyCount();
}
