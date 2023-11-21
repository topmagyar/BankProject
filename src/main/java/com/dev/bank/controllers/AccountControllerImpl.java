package com.dev.bank.controllers;

import com.dev.bank.controllers.client.AccountController;
import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.models.response.UserAccountsResponse;
import com.dev.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService service;

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        return service.createAccount(request);
    }

    @Override
    public UserAccountsResponse getUserAccounts(Integer userId) {
        return service.getUserAccounts(userId);
    }
}
