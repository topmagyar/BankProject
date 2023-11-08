package com.dev.bank.security;

import com.dev.bank.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenValidationInterceptor implements HandlerInterceptor {

    private static final String BANK_SECURITY_TOKEN_NAME = "BankToken";

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(RequiresTokenValidation.class)) {
                String token = request.getHeader(BANK_SECURITY_TOKEN_NAME);
                boolean valid = tokenService.isTokenValid(token);

                if (valid) {
                    return true;
                } else {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write("Invalid Token. Please, try to refresh your token");
                    response.getWriter().flush();

                    return false;
                }
            }
        }

        return true;
    }
}
