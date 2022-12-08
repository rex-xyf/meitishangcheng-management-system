package service;

import mapper.ManagerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Manager;
import utils.GetSqlSessionFactory;

public class ManagerService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.get();
    public Manager select(Manager manager){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        Manager manager1 = mapper.select(manager);
        sqlSession.close();
        return manager1;
    }
    public Manager selectOne(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        Manager manager1 = mapper.selectOne(username);
        sqlSession.close();
        return manager1;
    }

    public void add(Manager manager){
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        mapper.add(manager);
        sqlSession.close();
    }

    public Manager selectByEmail(String email){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        Manager manager1 = mapper.selectByEmail(email);
        sqlSession.close();
        return manager1;
    }

    public Manager find(Manager manager){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        Manager manager1 = mapper.find(manager);
        sqlSession.close();
        return manager1;
    }

    public void updatePassword(Manager manager){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        mapper.updatePassword(manager);
        sqlSession.close();
    }

    public void updatePagePassword(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        mapper.updatePagePassword(username,password);
        sqlSession.close();
    }

}
