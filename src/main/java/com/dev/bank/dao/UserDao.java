package com.dev.bank.dao;

import com.dev.bank.models.dao.User;

import java.util.List;

public interface UserDao {
    Integer save(User newUser);
    User findByEmail(String email);
    List<User> findAllUsers();
    User findById(Integer userId);
}
