package com.yar.onlinestore.common.exception;

/**
 * Created by EhsanYar on 8/2/2017.
 */
public class RepetitiveChargeRequestException extends ServiceException {
    public RepetitiveChargeRequestException() {
        super();
    }

    public RepetitiveChargeRequestException(String message) {
        super(message);
    }

    public RepetitiveChargeRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepetitiveChargeRequestException(Throwable cause) {
        super(cause);
    }

    protected RepetitiveChargeRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
