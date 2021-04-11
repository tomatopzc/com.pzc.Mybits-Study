package com.pzc.mapper;

import com.pzc.pojo.User;
import com.pzc.utils.MabitsUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MabitsUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void byId(){
        SqlSession sqlSession = MabitsUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }
    @Test
    public void addUserTest(){
        SqlSession sqlSession = MabitsUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int a = mapper.addUser(new User(6,"pzc11","123456"));

        if (a>0){
            System.out.println("insert成功");
        }else{
            System.out.println("失败");
        }

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void upDate(){
          SqlSession sqlSession = MabitsUtils.getSqlSession();
          UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.upDate(new User(5,"wyn","123"));

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession = MabitsUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteById(5);

        sqlSession.commit();
        sqlSession.close();
    }
}
