package com.dev.bank.services;

import com.dev.bank.converter.DtoConverter;
import com.dev.bank.dao.AccountDao;
import com.dev.bank.dao.UserDao;
import com.dev.bank.models.AccountDto;
import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.models.response.UserAccountsResponse;
import com.dev.bank.util.AccountType;
import com.dev.bank.util.CreditCardGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        if (user.getId() == -1) {
            response.setSuccess(false);
            response.setMessage("User with id: '" + userId + "' doesn't exist");

            return response;
        }

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

    public UserAccountsResponse getUserAccounts(Integer userId) {
        UserAccountsResponse response = new UserAccountsResponse();

        if (userId == null || userId < 1) {
            response.setSuccess(false);
            response.setMessage("Request should include valid user id");

            return response;
        }

        User user = userDao.findById(userId);

        if (user.getId() == -1) {
            response.setSuccess(false);
            response.setMessage("User with id: '" + userId + "' doesn't exist");

            return response;
        }

        List<Account> accounts = accountDao.getAccounts(user);
        if (accounts.isEmpty()) {
            response.setSuccess(true);
            response.setMessage("User with id: '" + userId + "' doesn't have any accounts");

            return response;
        }

        List<AccountDto> accountDtoList = accounts.stream()
                .map(DtoConverter::toDto)
                .collect(Collectors.toList());

        response.setSuccess(true);
        response.setAccounts(accountDtoList);

        return response;
    }
}
