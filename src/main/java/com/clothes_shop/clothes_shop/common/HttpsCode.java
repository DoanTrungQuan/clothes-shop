package com.clothes_shop.clothes_shop.common;

public enum HttpsCode {
    OK(200),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    HttpsCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
