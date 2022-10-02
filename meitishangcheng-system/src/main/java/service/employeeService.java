package service;

import mapper.employeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.employee;
import utils.getSqlSessionFactory;

import java.util.List;

public class employeeService {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory.get();
    public List<employee> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        employeeMapper mapper = sqlSession.getMapper(employeeMapper.class);
        List<employee> employees = mapper.selectAll();
        sqlSession.close();
        return employees;
    }

    public void add(employee Employee) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        employeeMapper mapper = sqlSession.getMapper(employeeMapper.class);
        mapper.add(Employee);
        sqlSession.close();
    }

    public employee selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        employeeMapper mapper = sqlSession.getMapper(employeeMapper.class);
        employee Employee = mapper.selectById(id);
        sqlSession.close();
        return Employee;
    }

    public void update(employee Employee){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        employeeMapper mapper = sqlSession.getMapper(employeeMapper.class);
        mapper.update(Employee);
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        employeeMapper mapper = sqlSession.getMapper(employeeMapper.class);
        mapper.delete(id);
        sqlSession.close();
    }
}
