package com.yar.onlinestore.dao.domain.enums;


import java.io.Serializable;

/**
 * Created by E.YARMOHAMMADI on 7/26/2017.
 */
@SuppressWarnings("unused")
public enum PaymentStatus implements Serializable {
    SUCCESSFUL(0),
    UNSUCCESSFUL(1),
    CONFLICT(2);

    private Integer code;

    PaymentStatus(Integer code) {
        this.code = code;
    }


    public static PaymentStatus fromValue(Integer value) {

        switch (value) {
            case 0:
                return SUCCESSFUL;
            case 1:
                return UNSUCCESSFUL;
            case 2:
                return CONFLICT;
            default:
                return UNSUCCESSFUL;

        }
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "PaymentStatus{" +
                "code=" + code +
                '}';
    }
}
