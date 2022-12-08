package service;

import mapper.DepartmentMapper;
import mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Department;
import pojo.Employee;
import utils.GetSqlSessionFactory;

import java.util.List;

public class DepartmentService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();
    public List<Department> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departForm = mapper.selectAll();
        sqlSession.close();
        return departForm;
    }

    public void add(Department department) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        mapper.add(department);
        sqlSession.close();
    }
}
