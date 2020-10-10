package com.term.dao;

import com.term.model.User;
import com.term.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    private static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testGetAllUsers(){
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getAllUsers();
        for(User user : users){
            System.out.println(user);
        }
        sqlSession.close();

    }


    @Test
    public void testAddUser() {
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.addUser(new User(12, "li", "zhang3"));
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

    @Test
    public void teatGetUsersByLimit() {
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> users = userDao.getUsersByLimit(map);
        for (User user : users)
            System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetUsersByRowBounds() {
        logger.info("start test GetUsersByRowBounds!");
        final SqlSession sqlSession = MybatisUtils.getSqlSession();

        final List<User> users = sqlSession.selectList("com.term.dao.UserDao.getUsersByRowBounds",
                null, new RowBounds(0, 2));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetAllUsersByAnnotation() {
        final SqlSession sqlSession = MybatisUtils.getSqlSession();

        final List<User> users = sqlSession.getMapper(UserDao.class).getAllUsersByAnnotation();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
