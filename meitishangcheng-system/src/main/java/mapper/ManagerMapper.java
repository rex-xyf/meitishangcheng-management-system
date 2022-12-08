package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Manager;

import java.util.List;

public interface ManagerMapper {
    List<Manager> selectAll();

    Manager select(Manager manager);

    Manager selectOne(String username);

    void add(Manager manager);

    Manager find(Manager manager);

    Manager selectByEmail(String email);

    void updatePassword(Manager manager);

    void updatePagePassword(@Param("username") String username, @Param("password") String password);
}
