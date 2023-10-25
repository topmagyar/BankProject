package com.dev.bank.controllers.client;

import com.dev.bank.models.UserDto;
import com.dev.bank.models.response.AllUsersResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {

    @GetMapping("/get/all")
    AllUsersResponse getAllUsers();
}
