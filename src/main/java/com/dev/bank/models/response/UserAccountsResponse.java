package com.dev.bank.models.response;

import com.dev.bank.models.AccountDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class UserAccountsResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AccountDto> accounts;

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }
}
