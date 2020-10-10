package com.term.dao;

import com.term.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getAllUsers();
    int updateUser(User user);
    int addUser(User user);
    int deleteUser(int id);
    User getOneUser(Map<String, Object> map);
    List<User> getUsersByNameLike(String name);

}
