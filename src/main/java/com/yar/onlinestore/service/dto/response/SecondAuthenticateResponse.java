package com.yar.onlinestore.service.dto.response;

/**
 * Created by EhsanYar on 7/23/2017.
 */
public class SecondAuthenticateResponse extends GeneralResponse {


    private   Byte[] result;

    public Byte[] getResult() {
        return result;
    }

    public void setResult(Byte[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SecondAuthenticateResponse{" +
                "result=" + bytesToHex(result) +
                '}';
    }
}
