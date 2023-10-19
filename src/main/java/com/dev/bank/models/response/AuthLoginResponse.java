package com.dev.bank.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AuthLoginResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
