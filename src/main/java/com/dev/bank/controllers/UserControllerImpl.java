package com.dev.bank.controllers;

import com.dev.bank.controllers.client.UserController;
import com.dev.bank.models.UserDto;
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
    public UserDto createUser(UserDto user) {
        return userService.createUser(user);
    }
}
