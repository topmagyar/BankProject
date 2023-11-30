package com.dev.bank.services;

import com.dev.bank.configs.App;
import com.dev.bank.dao.AccountDao;
import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.models.response.UserAccountsResponse;
import com.dev.bank.util.AccountType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AccountServiceTest {

    @Autowired
    private AccountService service;
    @MockBean
    private UserDao userDao;
    @MockBean
    private AccountDao accountDao;

    @Test
    public void testCreateAccount() {
        //mock fake user for userDao find process
        User fakeUser = new User();
        fakeUser.setId(1);
        fakeUser.setFirstName("Fake");
        given(userDao.findById(1)).willReturn(fakeUser);

        //mock fake account for accountDao save account process
        Account fakeAccount = new Account();
        fakeAccount.setId(123);
        fakeAccount.setUser(fakeUser);
        fakeAccount.setType(AccountType.USD);
        given(accountDao.saveAccount(any())).willReturn(fakeAccount);


        //create test request for testing method
        CreateAccountRequest request = new CreateAccountRequest();
        request.setUserId(1);
        request.setType(AccountType.USD);

        //run test method
        CreateAccountResponse response = service.createAccount(request);
        assertNotNull(response);
        assertEquals(123, response.getAccountId().intValue());

        //second run test method
        request = new CreateAccountRequest();
        request.setType(AccountType.USD);
        response = service.createAccount(request);

        assertFalse(response.getSuccess());
        assertEquals("Request should include valid user id", response.getMessage());

        //3rd run test method
        request = new CreateAccountRequest();
        request.setUserId(1);
        response = service.createAccount(request);

        assertFalse(response.getSuccess());
        assertEquals("Request should include account type", response.getMessage());
    }

    @Test
    public void testGetUserAccounts() {
        //check test when userId is null
        UserAccountsResponse response = service.getUserAccounts(null);
        assertFalse(response.getSuccess());
        assertEquals("Request should include valid user id", response.getMessage());

        //check test when user does not exist
        User nonExistedUser = new User();
        nonExistedUser.setId(-1);
        nonExistedUser.setFirstName("NONE");
        given(userDao.findById(123)).willReturn(nonExistedUser);
        response = service.getUserAccounts(123);
        assertFalse(response.getSuccess());
        assertEquals("User with id: '" + 123 + "' doesn't exist", response.getMessage());

        //run test with valid data
        User existedUser = new User();
        existedUser.setId(5);
        existedUser.setFirstName("Existed");
        existedUser.setLastName("User");
        given(userDao.findById(5)).willReturn(existedUser);

        response = service.getUserAccounts(5);
        assertTrue(response.getSuccess());
        assertEquals("User with id: '" + 5 + "' doesn't have any accounts", response.getMessage());

        Account fakeAccount = new Account();
        fakeAccount.setId(1);
        fakeAccount.setUser(existedUser);
        fakeAccount.setBalance(123.0);
        fakeAccount.setType(AccountType.USD);

        List<Account> fakeAccountList = new ArrayList<>();
        fakeAccountList.add(fakeAccount);

        given(accountDao.getAccounts(existedUser)).willReturn(fakeAccountList);

        response = service.getUserAccounts(5);
        assertTrue(response.getSuccess());
        assertNotNull(response.getAccounts());
        assertEquals(1, response.getAccounts().size());
    }
}
