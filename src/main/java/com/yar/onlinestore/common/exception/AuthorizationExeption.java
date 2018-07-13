package com.yar.onlinestore.common.exception;

public class AuthorizationExeption extends RequestException {
    public AuthorizationExeption() {
        super();
    }

    public AuthorizationExeption(String message) {
        super(message);
    }

    public AuthorizationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationExeption(Throwable cause) {
        super(cause);
    }

    protected AuthorizationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
