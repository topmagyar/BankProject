package com.dev.bank.models.request;

import com.dev.bank.util.AccountType;

public class CreateAccountRequest {

    private Integer userId;
    private AccountType type;

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
