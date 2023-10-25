package com.dev.bank.models.response;

import com.dev.bank.models.UserDto;

import java.util.List;

public class AllUsersResponse extends BaseResponse {

    private List<UserDto> users;

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<UserDto> getUsers() {
        return users;
    }
}
