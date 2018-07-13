package com.yar.onlinestore.service.dto.response;

/**
 * Created by EhsanYar on 7/23/2017.
 */
public class FirstAuthenticateResponse extends GeneralResponse {

    private  Byte[] randomAB;

    public Byte[] getRandomAB() {
        return randomAB;
    }

    public void setRandomAB(Byte[] randomAB) {
        this.randomAB = randomAB;
    }

    @Override
    public String toString() {
        return "FirstAuthenticateResponse{" +
                "randomAB=" + bytesToHex(randomAB) +
                '}';
    }

}
