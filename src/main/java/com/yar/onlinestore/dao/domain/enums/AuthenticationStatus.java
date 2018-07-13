package com.yar.onlinestore.dao.domain.enums;

/**
 * Created by E.YARMOHAMMADI on 8/19/2017.
 */
@SuppressWarnings({"unused", "Duplicates"})
public enum AuthenticationStatus {
    Successful(0),
    Reject(1),
    InProgress(2),
    Delay(3),
    TimeOut(4);

    private Integer code;

    AuthenticationStatus(Integer code) {
        this.code = code;
    }


    public static AuthenticationStatus fromCode(Integer code) {

        switch (code) {
            case 0:
                return Successful;
            case 1:
                return Reject;
            case 2:
                return InProgress;
            case 3:
                return Delay;
            case 4:
                return TimeOut;
            default:
                return Reject;

        }
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "AuthenticationStatus{" +
                "code=" + code +
                '}';
    }
}
