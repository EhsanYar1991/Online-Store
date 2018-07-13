package com.yar.onlinestore.dao.domain.enums;


@SuppressWarnings({"Duplicates", "unused"})
public enum TransactionType {

    PAYMENT(1),
    PURCHASE(2),
    BILL(3),
    BALANCE(4),
    OTHER(0);

    private Integer code;

    TransactionType(Integer code) {
        this.code = code;
    }


    public static TransactionType fromCode(Integer code) {

        switch (code) {
            case 0:
                return OTHER;
            case 1:
                return PAYMENT;
            case 2:
                return PURCHASE;
            case 3:
                return BILL;
            case 4:
                return BALANCE;
            default:
                return OTHER;

        }
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "code=" + code +
                '}';
    }
}
