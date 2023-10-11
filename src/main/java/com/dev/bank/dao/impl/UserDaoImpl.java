package com.dev.bank.dao.impl;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.User;
import com.dev.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public Integer save(User newUser) {
        User createdUser = repository.save(newUser);

        return createdUser.getId();
    }
}
