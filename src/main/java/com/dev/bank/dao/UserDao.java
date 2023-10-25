package com.dev.bank.dao;

import com.dev.bank.models.dao.User;

import java.util.List;

public interface UserDao {
    public Integer save(User newUser);
    public User findByEmail(String email);
    public List<User> findAllUsers();
}
