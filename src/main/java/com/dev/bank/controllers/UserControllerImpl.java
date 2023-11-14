package com.dev.bank.controllers;

import com.dev.bank.controllers.client.UserController;
import com.dev.bank.models.UserDto;
import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.models.response.UserResponse;
import com.dev.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    public UserControllerImpl() {
    }

    @Override
    public AllUsersResponse getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserResponse getUserById(Integer userId) {
        return userService.getUserById(userId);
    }
}
