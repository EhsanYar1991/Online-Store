package com.yar.onlinestore.service.enums;

/**
 * Created by EhsanYar on 8/6/2017.
 */
public enum ErrorMessageEnum {

    CREATE_SESSION(200),
    RE_CREATE_SESSION(201),
    REPETITIVE_TRANSACTION_INFO(202),
    INVALID_ENTRY_DATA(203),
    INVALID_TRANSACTION_RRN(204),
    Client_RESPONSE_ERROR(205),
    COULD_NOT_GET_ANY_RESPONSE_FROM_ASR_DANESH_AFZAR(206),
    ACCESS_DENIED(207),
    SAM_ERROR(208),
    TOKEN_IS_EMPTY(209),
    INVALID_TOKEN(210),
    TRANSACTION_REGISTRATION_FAILED(211);


    ErrorMessageEnum(Integer errorCode) {
        this.errorCode = errorCode;
    }

    private Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }
}
