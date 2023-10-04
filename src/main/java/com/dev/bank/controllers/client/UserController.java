package com.dev.bank.controllers.client;

import com.dev.bank.models.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {

    @GetMapping("/hello")
    String helloUser();

    @GetMapping("/get/test") //localhost:8080/user/get/test
    UserDto getTestUser();

    @PostMapping("/create")
    UserDto createUser(@RequestBody UserDto user);
}
