package com.term.dao;

import com.term.model.User;
import com.term.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mybatis 增删改查Junit
 */
public class UserDaoTest {
    @Test
    public void testGetAllUser() {
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }


        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.addUser(new User(1, "li", "zhang3"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUser(new User(2, "lisi", "lisq"));

        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelUser(){
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUser(1);

        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetOneUser(){
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);

        System.out.println(userDao.getOneUser(map));
        sqlSession.close();
    }

    @Test
    public void testGetUsersByNameLike(){
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getUsersByNameLike("%l%");
        for (User user : users)
            System.out.println(user);
        sqlSession.close();
    }
}
