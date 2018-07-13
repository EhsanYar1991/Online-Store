package com.yar.onlinestore.dao.domain.enums;

/**
 * Created by EhsanYar on 8/28/2017.
 */
@SuppressWarnings("ALL")
public enum ServiceMethodStep {
    AUTHORIZATION_METHOD(0),
    FIRST_AUTHENTICATE_METHOD(1),
    SECOND_AUTHENTICATE_METHOD(2),
    TRANSACTION_LOG_METHOD(3),
    PROCESS_REPORT_METHOD(4);

    private Integer code;

    ServiceMethodStep(Integer code) {
        this.code = code;
    }


    public static ServiceMethodStep fromCode(Integer code) {

        switch (code) {
            case 0:
                return AUTHORIZATION_METHOD;
            case 1:
                return FIRST_AUTHENTICATE_METHOD;
            case 2:
                return SECOND_AUTHENTICATE_METHOD;
            case 3:
                return TRANSACTION_LOG_METHOD;
            case 4:
                return PROCESS_REPORT_METHOD;
            default:
                return AUTHORIZATION_METHOD;

        }
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ServiceMethodStep{" +
                "code=" + code +
                '}';
    }
}
