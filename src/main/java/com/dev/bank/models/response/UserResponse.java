package com.dev.bank.models.response;

import com.dev.bank.models.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;

public class UserResponse extends BaseResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto user;

    public void setUser(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }
}
