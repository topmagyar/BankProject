package com.dev.bank.services;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.request.AuthLoginRequest;
import com.dev.bank.models.request.AuthRegisterRequest;
import com.dev.bank.models.response.AuthLoginResponse;
import com.dev.bank.models.response.AuthRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.time.ZonedDateTime;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthLoginResponse login(AuthLoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        if (email == null || email.isEmpty()) {
            AuthLoginResponse response = new AuthLoginResponse();

            response.setSuccess(false);
            response.setMessage("Email field is required");

            return response;
        }

        if (password == null || password.isEmpty()) {
            AuthLoginResponse response = new AuthLoginResponse();

            response.setSuccess(false);
            response.setMessage("Your password can't be null or empty");

            return response;
        }

        User user = userDao.findByEmail(email);
        if (user == null) {
            AuthLoginResponse response = new AuthLoginResponse();

            response.setSuccess(false);
            response.setMessage("User with email '" + email + "' doesn't exist in system");

            return response;
        }

        String expectedHashedPassword = user.getPassword();
        if (!passwordEncoder.matches(password, expectedHashedPassword)) {
            AuthLoginResponse response = new AuthLoginResponse();

            response.setSuccess(false);
            response.setMessage("Password is incorrect");

            return response;
        }

        AuthLoginResponse response = new AuthLoginResponse();

        response.setSuccess(true);
        response.setUserId(user.getId());
        //TODO add token implementation
        response.setToken();

        return response;
    }

    public AuthRegisterResponse register(AuthRegisterRequest request) {
        ZonedDateTime birthdayDate = request.getBirthday();
        if (!validAge(birthdayDate)) {
            AuthRegisterResponse response = new AuthRegisterResponse();

            response.setSuccess(false);
            response.setMessage("Unfortunately, we're not able to register your account as you're under 18");

            return response;
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setAge(getAge(birthdayDate));

        Integer newUserId = userDao.save(newUser);
        if (newUserId == null || newUserId == 0) {
            AuthRegisterResponse response = new AuthRegisterResponse();

            response.setSuccess(false);
            response.setMessage("Something goes wrong and we're not able to register your user!");

            return response;
        }

        AuthRegisterResponse response = new AuthRegisterResponse();

        response.setSuccess(true);
        response.setUserId(newUserId);
        //TODO add token implementation
        response.setToken();

        return response;
    }

    private Integer getAge(ZonedDateTime birthdayDate) {
        Period period = Period.between(birthdayDate.toLocalDate(), ZonedDateTime.now().toLocalDate());

        return period.getYears();
    }

    private boolean validAge(ZonedDateTime birthdayDate) {
        ZonedDateTime latestValidDate = ZonedDateTime.now().minusYears(18);

        return birthdayDate.isBefore(latestValidDate);
    }
}
