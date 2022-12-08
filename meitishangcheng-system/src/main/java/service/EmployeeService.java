package service;

import mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Employee;
import utils.GetSqlSessionFactory;

import java.util.List;

public class EmployeeService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();
    public List<Employee> selectAll(int currentPage, int pageSize,String key,String value){
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectAll(begin,size,key,value);
        sqlSession.close();
        return employees;
    }

    public void add(Employee employee) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.add(employee);
        sqlSession.close();
    }

    public void addId(Employee employee) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.addId(employee);
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.delete(id);
        sqlSession.close();
    }

    public void update(Employee employee){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.update(employee);
        sqlSession.close();
    }

    public Employee selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectById(id);
        sqlSession.close();
        return employee;
    }

    public void deleteByIds (int[] ids){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.close();
    }

    public int count(String key,String value){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int count = mapper.count(key,value);
        sqlSession.close();
        return count;
    }

    public List<Employee> selectByIds(int[] ids){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectByIds(ids);
        sqlSession.close();
        return employees;
    }
}
