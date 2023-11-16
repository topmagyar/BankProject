package com.dev.bank.services;

import com.dev.bank.dao.AccountDao;
import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.util.AccountType;
import com.dev.bank.util.CreditCardGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserDao userDao;

    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        CreateAccountResponse response = new CreateAccountResponse();

        Integer userId = request.getUserId();

        if (userId == null || userId < 1) {
            response.setSuccess(false);
            response.setMessage("Request should include valid user id");

            return response;
        }

        AccountType accountType = request.getType();

        if (accountType == null) {
            response.setSuccess(false);
            response.setMessage("Request should include account type");

            return response;
        }

        User user = userDao.findById(userId);

        Account newAccount = new Account();
        newAccount.setType(accountType);
        newAccount.setBalance(0.0);
        newAccount.setUser(user);
        newAccount.setNumber(CreditCardGenerator.generateCardNumber());

        Account createdAccount = accountDao.saveAccount(newAccount);

        response.setSuccess(true);
        response.setAccountId(createdAccount.getId());
        response.setCardNumber(createdAccount.getNumber());


        return response;
    }
}
