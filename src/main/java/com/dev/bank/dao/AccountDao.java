package com.dev.bank.dao;

import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;

import java.util.List;

public interface AccountDao {
    Account saveAccount(Account account);
    List<Account> getAccounts(User user);
}
