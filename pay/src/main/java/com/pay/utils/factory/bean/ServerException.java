package com.pay.utils.factory.bean;

public class ServerException extends Exception {

    private String errorCode;
    private String errorMessage;

    public ServerException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getLocalizedMessage() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
