package com.yar.onlinestore.service.dto.request;

import java.io.Serializable;

/**
 * Created by EhsanYar on 8/28/2017.
 */
public class CardRequest implements Serializable {

    private static final long serialVersionUID = -2694455155660999156L;

    private String uid;
    private int actionCode;
    private String actionMessage;

    public CardRequest() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    public int getActionCode() {
        return actionCode;
    }

    public void setActionCode(int actionCode) {
        this.actionCode = actionCode;
    }


    @Override
    public String toString() {
        return "CardRequest{" +
                ", uid='" + uid + '\'' +
                ", actionCode=" + actionCode +
                ", actionMessage='" + actionMessage + '\'' +
                '}';
    }
}
