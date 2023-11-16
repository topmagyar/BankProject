package com.dev.bank.controllers.client;

import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.security.RequiresTokenValidation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
public interface AccountController {

    @PostMapping("/create")
    @RequiresTokenValidation
    CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request);
}
