package com.clothes_shop.clothes_shop.common;

public enum StatusOrder {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED");

    private String status;
    StatusOrder(String status) {
        this.status = status;
    }
}
