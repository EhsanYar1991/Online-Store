package com.yar.onlinestore.service.dto.request;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by EhsanYar on 7/23/2017.
 */

public class FirstAuthenticateRequest implements Serializable {

    private static final long serialVersionUID = -2694444155660999156L;
    private byte[] randomB;
    private byte[] uid;
    private byte keyNo;
    private Integer keyTable;


    public byte[] getRandomB() {
        return randomB;
    }

    public void setRandomB(byte[] randomB) {
        this.randomB = randomB;
    }

    public byte[] getUid() {
        return uid;
    }

    public void setUid(byte[] uid) {
        this.uid = uid;
    }

    public byte getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(byte keyNo) {
        this.keyNo = keyNo;
    }

    public Integer getKeyTable() {
        return keyTable;
    }

    public void setKeyTable(Integer keyTable) {
        this.keyTable = keyTable;
    }

    public String getHexUid() {
        return bytesToHex(uid);
    }

    @Override
    public String toString() {
        return "FirstAuthenticateRequest{" +
                ", randomB=" + Arrays.toString(randomB) +
                ", uid=" + bytesToHex(uid) +
                ", keyNo=" + keyNo +
                ", keyTable=" + keyTable +
                '}';
    }


    private String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}