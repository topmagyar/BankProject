package com.dev.bank.dao.impl;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.User;
import com.dev.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public Integer save(User newUser) {
        User createdUser = null;

        try {
            createdUser = repository.save(newUser);
        } catch (Exception e) {
            System.out.println("We got exception: " + e.getMessage());
            return 0;
        }

        return createdUser.getId();
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findById(Integer userId) {
        Optional<User> userOptional = repository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            User nullUser = new User();
            nullUser.setId(-1);

            return nullUser;
        }
    }
}
