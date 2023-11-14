package com.dev.bank.controllers.client;

import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.models.response.UserResponse;
import com.dev.bank.security.RequiresTokenValidation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {

    @GetMapping("/get/all")
    @RequiresTokenValidation
    AllUsersResponse getAllUsers();

    @GetMapping("/get/{userId}")
    @RequiresTokenValidation
    UserResponse getUserById(@PathVariable("userId") Integer userId);
}