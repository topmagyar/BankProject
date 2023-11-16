package com.dev.bank.models.response;

public class CreateAccountResponse extends BaseResponse {

    private Integer accountId;
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
