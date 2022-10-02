package service;

import mapper.managerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.manager;
import utils.getSqlSessionFactory;

public class managerService {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory.get();
    public manager select(manager manager){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        managerMapper mapper = sqlSession.getMapper(managerMapper.class);
        manager manager1 = mapper.select(manager);
        sqlSession.close();
        return manager1;
    }
    public manager selectOne(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        managerMapper mapper = sqlSession.getMapper(managerMapper.class);
        manager manager1 = mapper.selectOne(username);
        sqlSession.close();
        return manager1;
    }

    public void add(manager manager){
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        managerMapper mapper = sqlSession.getMapper(managerMapper.class);
        mapper.add(manager);
        sqlSession.close();
    }

}
