package com.dev.bank.controllers.client;

import com.dev.bank.models.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {

    @PostMapping("/create")
    UserDto createUser(@RequestBody UserDto user);
}
