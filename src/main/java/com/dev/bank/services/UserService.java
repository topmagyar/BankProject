package com.dev.bank.services;

import com.dev.bank.models.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserService() {
    }

    public UserDto createTestUser() {
        UserDto user = new UserDto();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Backer");
        user.setEmail("jbacker@gmail.com");

        return user;
    }

    public UserDto addUserFromRest(UserDto userDto) {
        userDto.setEmail("abc@gmail.com");
        return userDto;
    }
}
