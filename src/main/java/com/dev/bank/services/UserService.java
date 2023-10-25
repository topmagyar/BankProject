package com.dev.bank.services;

import com.dev.bank.converter.DtoConverter;
import com.dev.bank.dao.UserDao;
import com.dev.bank.models.UserDto;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.response.AllUsersResponse;
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
}
