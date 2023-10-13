package com.dev.bank.dao;

import com.dev.bank.models.dao.User;

public interface UserDao {
    public Integer save(User newUser);
}
