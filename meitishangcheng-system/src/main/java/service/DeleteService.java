package service;

import mapper.DeleteMapper;
import mapper.DepartmentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Delete;
import pojo.Employee;
import utils.GetSqlSessionFactory;

import java.util.List;

public class DeleteService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();
    public void add(Employee employee){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        mapper.add(employee);
        sqlSession.close();
    }

    public void addInformation(Employee employee){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        mapper.addInformation(employee);
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        mapper.delete(id);
        sqlSession.close();
    }

    public List<Delete> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        List<Delete> deletes = mapper.selectAll();
        sqlSession.close();
        return deletes;
    }

    public Delete selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        Delete delete = mapper.selectById(id);
        sqlSession.close();
        return delete;
    }

    public int count(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        int count1 = mapper.count();
        return count1;
    }

    public List<Delete> selectAllByState(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        List<Delete> deletes = mapper.selectAllByState();
        sqlSession.close();
        return deletes;
    }

    public int modifyCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeleteMapper mapper = sqlSession.getMapper(DeleteMapper.class);
        int count1 = mapper.modifyCount();
        return count1;
    }
}
