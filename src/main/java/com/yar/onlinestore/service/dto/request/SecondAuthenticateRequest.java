package com.yar.onlinestore.service.dto.request;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by EhsanYar on 7/23/2017.
 */
public class SecondAuthenticateRequest implements Serializable {

    private static final long serialVersionUID = -109581524681473504L;
    private byte[] uid;
    private byte[] randomA;


    public byte[] getRandomA() {
        return randomA;
    }

    public void setRandomA(byte[] randomA) {
        this.randomA = randomA;
    }

    public byte[] getUid() {
        return uid;
    }

    public void setUid(byte[] uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "SecondAuthenticateRequest{" +
                ", uid=" + Arrays.toString(uid) +
                ", randomA=" + Arrays.toString(randomA) +
                '}';
    }
}
