package mapper;

import pojo.manager;

import java.util.List;

public interface managerMapper {
    List<manager> selectAll();

    manager select(manager manager);

    manager selectOne(String username);

    void add(manager manager);
}
