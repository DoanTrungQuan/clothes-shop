package com.clothes_shop.clothes_shop.common;

public enum EError {
    USER_EXISTED("User already exists"),
    USER_NOT_FOUND("User not found"),
    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_EXISTED("Product already exists"),
    HASHTAG_CATEGORY_NOT_FOUND("Hashtag category not found"),
    HASHTAG_CATEGORY_EXISTED("Hashtag category already exists");
    private final String message;

    EError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
