package com.dev.bank.services;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.UserDto;
import com.dev.bank.models.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
    }

    public UserDto createUser(UserDto userDto) {
        User repositoryUser = new User();
        repositoryUser.setFirstName(userDto.getFirstName());
        repositoryUser.setLastName(userDto.getLastName());
        repositoryUser.setEmail(userDto.getEmail());
        repositoryUser.setAge(userDto.getAge());

        Integer createdUserId = userDao.save(repositoryUser);

        UserDto response = new UserDto();
        response.setId(createdUserId);

        return response;
    }
}
