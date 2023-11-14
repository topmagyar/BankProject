package com.dev.bank.services;

import com.dev.bank.converter.DtoConverter;
import com.dev.bank.dao.UserDao;
import com.dev.bank.models.UserDto;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.models.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
    }

    public AllUsersResponse getAllUsers() {
        AllUsersResponse response = new AllUsersResponse();

        List<User> users = userDao.findAllUsers();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto dto = DtoConverter.toDto(user);
            userDtoList.add(dto);
        }

        response.setSuccess(true);
        response.setUsers(userDtoList);

        return response;
    }

    public UserResponse getUserById(Integer userId) {
        UserResponse response = new UserResponse();

        if (userId == null) {
            response.setSuccess(false);
            response.setMessage("User id couldn't be null");

            return response;
        }

        User user = userDao.findById(userId);

        if (user.getId() == -1) {
            response.setSuccess(false);
            response.setMessage("User with id '" + userId + "' was not found");

            return response;
        }

        response.setSuccess(true);
        UserDto userDto = DtoConverter.toDto(user);
        response.setUser(userDto);

        return response;
    }
}
