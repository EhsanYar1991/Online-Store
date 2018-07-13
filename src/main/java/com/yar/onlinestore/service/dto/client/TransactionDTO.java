package com.yar.onlinestore.service.dto.client;

import java.io.Serializable;


public class TransactionDTO implements Serializable {

    private static final long serialVersionUID = -1627508333672618681L;

    private Integer transactionTypeCode;

    private String cardNumber;

    private String hashedCardNumber;

    private String transactionDateTime;

    private String referenceNumber;

    private String stan;

    private Integer paymentStatusCode;

    private Long amount;

    private Long terminalId;

    private Long paymentId;

    private Integer responseCode;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }


    public Integer getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(Integer transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHashedCardNumber() {
        return hashedCardNumber;
    }

    public void setHashedCardNumber(String hashedCardNumber) {
        this.hashedCardNumber = hashedCardNumber;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public Integer getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(Integer paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                ", transactionTypeCode=" + transactionTypeCode +
                ", cardNumber='" + cardNumber + '\'' +
                ", hashedCardNumber='" + hashedCardNumber + '\'' +
                ", transactionDateTime=" + transactionDateTime +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", stan='" + stan + '\'' +
                ", paymentStatusCode=" + paymentStatusCode +
                ", amount=" + amount +
                ", terminalId=" + terminalId +
                ", paymentId=" + paymentId +
                ", responseCode=" + responseCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
