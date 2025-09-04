package com.clothes_shop.clothes_shop.common;

public enum EError {
    USER_EXISTED("User already exists"),
    USER_NOT_FOUND("User not found");
    private final String message;

    EError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
