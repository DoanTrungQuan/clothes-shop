package com.clothes_shop.clothes_shop.common;

public enum EError {
    USER_EXISTED("User already exists"),
    USER_NOT_FOUND("User not found"),
    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_EXISTED("Product already exists");
    private final String message;

    EError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
