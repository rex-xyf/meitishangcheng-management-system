package mapper;

import pojo.Manager;

import java.util.List;

public interface ManagerMapper {
    List<Manager> selectAll();

    Manager select(Manager manager);

    Manager selectOne(String username);

    void add(Manager manager);

    Manager selectByEmail(Manager manager);
}
