package com.yar.onlinestore.common.exception;

import java.io.Serializable;

/**
 * Created by EhsanYar.
 */
public abstract class InternalException extends Exception implements Serializable {

    private static final long serialVersionUID = 6271934941966893011L;

    public InternalException() {
        super();
    }

    public InternalException(String message) {
        super(message);
    }

    public InternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalException(Throwable cause) {
        super(cause);
    }

    protected InternalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
