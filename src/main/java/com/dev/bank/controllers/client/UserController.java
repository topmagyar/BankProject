package com.dev.bank.controllers.client;

import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.security.RequiresTokenValidation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {

    @GetMapping("/get/all")
    @RequiresTokenValidation
    AllUsersResponse getAllUsers();
}
