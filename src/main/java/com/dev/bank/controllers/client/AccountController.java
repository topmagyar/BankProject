package com.dev.bank.controllers.client;

import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.models.response.UserAccountsResponse;
import com.dev.bank.security.RequiresTokenValidation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
public interface AccountController {

    @PostMapping("/create")
    @RequiresTokenValidation
    CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request);

    @GetMapping("/get/user/{userId}")
    @RequiresTokenValidation
    UserAccountsResponse getUserAccounts(@PathVariable("userId") Integer userId);

}
