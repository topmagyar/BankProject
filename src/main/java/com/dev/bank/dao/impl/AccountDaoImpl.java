package com.dev.bank.dao.impl;

import com.dev.bank.dao.AccountDao;
import com.dev.bank.models.dao.Account;
import com.dev.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository repository;

    @Override
    public Account saveAccount(Account account) {
        return repository.save(account);
    }
}
