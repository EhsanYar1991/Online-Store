package com.yar.onlinestore.service.dto.request;

import java.io.Serializable;

/**
 * Created by EhsanYar on 8/13/2017.
 */
public class AuthorizingRequest implements Serializable {

    private static final long serialVersionUID = -1797820219785634097L;
    private String uid;
    private String paymentRRN;
    private Long amount;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPaymentRRN() {
        return paymentRRN;
    }

    public void setPaymentRRN(String paymentRRN) {
        this.paymentRRN = paymentRRN;
    }


    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AuthorizingRequest{" +
                "uid='" + uid + '\'' +
                ", paymentRRN='" + paymentRRN + '\'' +
                ", amount=" + amount +
                '}';
    }
}
