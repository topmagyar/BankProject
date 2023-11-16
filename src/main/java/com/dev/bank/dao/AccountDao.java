package com.dev.bank.dao;

import com.dev.bank.models.dao.Account;

public interface AccountDao {
    Account saveAccount(Account account);
}
