package com.zzh.service;

import com.zzh.mapper.UserMapper;
import com.zzh.pojo.User;
import com.zzh.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User select(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user= mapper.select(username,password);
        sqlSession.close();
        return user;
    }

  public void add(String username, String password){
      SqlSession sqlSession = factory.openSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      mapper.add(username,password);
      sqlSession.commit();
      sqlSession.close();
  }
    public User selectByName(String username) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByName(username);
        sqlSession.close();
        return user;
    }

}
