package com.dev.bank.converter;

import com.dev.bank.models.UserDto;
import com.dev.bank.models.dao.User;

public class DtoConverter {

    //convert data from database object 'User' to transfer object 'UserDto'
    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());

        return dto;
    }
}
