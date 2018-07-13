package com.yar.onlinestore.configs.security;

public enum SecurityRole {

    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    USER("USER"),
    ANONYMOUS("ANONYMOUS");

    private String name;

    SecurityRole(String name) {
        this.name = name;
    }


    public String getRole() {
        return name;
    }

    @Override
    public String toString() {
        return "CardType{" +
                ", name='" + name + '\'' +
                '}';
    }
}
