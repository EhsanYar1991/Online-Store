package com.yar.onlinestore.service.dto.response;

/**
 * Created by EhsanYar on 8/6/2017.
 */
public class AuthorizingResponse extends GeneralResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthorizingResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
