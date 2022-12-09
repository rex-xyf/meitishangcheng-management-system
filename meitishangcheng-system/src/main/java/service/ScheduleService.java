package service;

import mapper.ScheduleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Schedule;
import utils.GetSqlSessionFactory;

import java.util.List;

public class ScheduleService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();

    public Schedule selectByName(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        Schedule schedule = mapper.selectByName(username);
        sqlSession.close();
        return schedule;
    }

    public void add(Schedule schedule){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        mapper.add(schedule);
        sqlSession.close();
    }

    public void renew(int id,String name){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        mapper.renew(id,name);
        sqlSession.close();
    }

    public void updateState(int id,int state){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        mapper.updateState(id,state);
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        mapper.delete(id);
        sqlSession.close();
    }

    public List<Schedule> selectAll(int currentPage, int pageSize,String key,String value){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;
        List<Schedule> schedules = mapper.selectAll(begin, size, key, value);
        sqlSession.close();
        return schedules;
    }

    public int count(String key,String value){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        int count = mapper.count(key, value);
        sqlSession.close();
        return count;
    }

    public void update(int id,boolean leave,int daysOff){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        mapper.update(id,leave,daysOff);
        sqlSession.close();
    }

    public List<Schedule> selectRequest(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        List<Schedule> schedules = mapper.selectRequest();
        sqlSession.close();
        return schedules;
    }

    public Schedule selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        Schedule schedule = mapper.selectById(id);
        sqlSession.close();
        return schedule;
    }

    public void updateAttendance(int id ,Boolean attendance){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        mapper.updateAttendance(id,attendance);
        sqlSession.close();
    }

    public int selectRequestCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        int count = mapper.selectRequestCount();
        sqlSession.close();
        return count;
    }

    public boolean[] selectAttendance(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        boolean[] attendance = mapper.selectAttendance();
        sqlSession.close();
        return attendance;
    }

    public boolean[] selectLeave(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
        boolean[] leave = mapper.selectLeave();
        sqlSession.close();
        return leave;
    }

}
