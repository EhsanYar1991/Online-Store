package com.yar.onlinestore.service.dto.request;

import java.io.Serializable;

/**
 * @author EhsanYar
 */
public class TransactionInfoRequest implements Serializable {


    private static final long serialVersionUID = -4315830813429009601L;


    private String cardUID;
    private String cardAccountNumber;
    private String expirationDate;
    private String applicationId;
    private String productId;
    private String cardTransactionCounter;
    private String transactionDateAndTime;
    private String originalEventAmount;
    private String eventAmount;
    private String referenceNumber; // transactionRRN
    private String lastBalance;
    private String newBalance;
    private String deviceId;
    private Integer cardTypeIndex;

    public TransactionInfoRequest() {
    }


    public String getCardUID() {
        return cardUID;
    }

    public void setCardUID(String cardUID) {
        this.cardUID = cardUID;
    }

    public String getCardAccountNumber() {
        return cardAccountNumber;
    }

    public void setCardAccountNumber(String cardAccountNumber) {
        this.cardAccountNumber = cardAccountNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCardTransactionCounter() {
        return cardTransactionCounter;
    }

    public void setCardTransactionCounter(String cardTransactionCounter) {
        this.cardTransactionCounter = cardTransactionCounter;
    }

    public String getTransactionDateAndTime() {
        return transactionDateAndTime;
    }

    public void setTransactionDateAndTime(String transactionDateAndTime) {
        this.transactionDateAndTime = transactionDateAndTime;
    }

    public String getOriginalEventAmount() {
        return originalEventAmount;
    }

    public void setOriginalEventAmount(String originalEventAmount) {
        this.originalEventAmount = originalEventAmount;
    }

    public String getEventAmount() {
        return eventAmount;
    }

    public void setEventAmount(String eventAmount) {
        this.eventAmount = eventAmount;
    }


    public String getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(String lastBalance) {
        this.lastBalance = lastBalance;
    }

    public String getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(String newBalance) {
        this.newBalance = newBalance;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Integer getCardTypeIndex() {
        return cardTypeIndex;
    }

    public void setCardTypeIndex(Integer cardTypeIndex) {
        this.cardTypeIndex = cardTypeIndex;
    }

    @Override
    public String toString() {
        return "TransactionInfoRequest{" +
                "cardUID='" + cardUID + '\'' +
                ", cardAccountNumber='" + cardAccountNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", productId='" + productId + '\'' +
                ", cardTransactionCounter='" + cardTransactionCounter + '\'' +
                ", transactionDateAndTime='" + transactionDateAndTime + '\'' +
                ", originalEventAmount='" + originalEventAmount + '\'' +
                ", eventAmount='" + eventAmount + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", lastBalance='" + lastBalance + '\'' +
                ", newBalance='" + newBalance + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", cardTypeIndex=" + cardTypeIndex +
                '}';
    }
}
