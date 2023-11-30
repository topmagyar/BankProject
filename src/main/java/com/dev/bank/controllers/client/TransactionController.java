package com.dev.bank.controllers.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transaction")
public interface TransactionController {

    @GetMapping("/account/{accountId}")
    //TODO add method

    @GetMapping("/get/{transactionId}")
    //TODO add method

    @PostMapping("/create")
    //TODO add method
}
