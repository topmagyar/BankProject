package com.dev.bank.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CreateAccountResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer accountId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cardNumber;

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
