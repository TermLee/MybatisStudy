package com.term.dao;

import com.term.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getAllUsers();
    int updateUser(User user);
    int addUser(User user);
    int deleteUser(int id);
    User getOneUser(Map<String, Object> map);
    List<User> getUsersByNameLike(String name);
    //分页查询
    List<User> getUsersByLimit(Map<String, Integer> map);
    List<User> getUsersByRowBounds();

    @Select("select * from user")
    List<User> getAllUsersByAnnotation();

}
