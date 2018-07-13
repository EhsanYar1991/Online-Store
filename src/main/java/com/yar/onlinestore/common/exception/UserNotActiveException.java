package com.yar.onlinestore.common.exception;

/**
 * Created by EhsanYar on 8/2/2017.
 */
public class UserNotActiveException extends UserServiceException {
    public UserNotActiveException() {
        super();
    }

    public UserNotActiveException(String message) {
        super(message);
    }

    public UserNotActiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotActiveException(Throwable cause) {
        super(cause);
    }

    protected UserNotActiveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
