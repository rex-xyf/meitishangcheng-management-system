package mapper;

import pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> selectAll();

    void add(Department department);
}
