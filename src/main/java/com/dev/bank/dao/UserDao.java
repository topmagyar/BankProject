package com.dev.bank.dao;

import com.dev.bank.models.dao.User;
import org.springframework.stereotype.Component;

public interface UserDao {
    public Integer save(User newUser);
}
