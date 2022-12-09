package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;
import pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> selectAll(@Param("begin") int begin, @Param("size") int size, @Param("key") String key, @Param("value") String value);

    int count(@Param("key") String key, @Param("value") String value);

    List<Schedule> selectRequest();

    int selectRequestCount();

    void update(@Param("id") int id,@Param("leave") Boolean leave ,@Param("daysOff") int daysOff);

    Schedule selectById(int id);

    Schedule selectByName(@Param("username") String username);

    void updateAttendance(@Param("id") int id,@Param("attendance") Boolean attendance);

    void add(Schedule schedule);

    void renew(@Param("id") int id,@Param("name") String name);

    void updateState(@Param("id") int id,@Param("state") int state);

    void delete(int id);

    boolean[] selectAttendance();

    boolean[] selectLeave();
}
