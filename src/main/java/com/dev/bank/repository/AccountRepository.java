package com.dev.bank.repository;

import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByUser(User user);
}
