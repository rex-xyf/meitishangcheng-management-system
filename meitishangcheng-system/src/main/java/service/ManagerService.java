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

    public Manager selectByEmail(Manager manager){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ManagerMapper mapper = sqlSession.getMapper(ManagerMapper.class);
        Manager manager1 = mapper.selectByEmail(manager);
        sqlSession.close();
        return manager1;
    }

}
