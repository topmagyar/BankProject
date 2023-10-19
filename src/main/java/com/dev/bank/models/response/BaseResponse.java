package com.dev.bank.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BaseResponse {

    private Boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
