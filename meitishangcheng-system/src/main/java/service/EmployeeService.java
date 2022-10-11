package service;

import mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Employee;
import utils.GetSqlSessionFactory;

import java.util.List;

public class EmployeeService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();
    public List<Employee> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectAll();
        sqlSession.close();
        return employees;
    }

    public void add(Employee Employee) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.add(Employee);
        sqlSession.close();
    }

    public Employee selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee Employee = mapper.selectById(id);
        sqlSession.close();
        return Employee;
    }

    public void update(Employee Employee){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.update(Employee);
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.delete(id);
        sqlSession.close();
    }

    public void deleteByIds( int[] ids){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.close();
    }
}
