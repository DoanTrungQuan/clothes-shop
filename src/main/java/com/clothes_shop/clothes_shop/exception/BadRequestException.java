package com.clothes_shop.clothes_shop.exception;
import com.clothes_shop.clothes_shop.common.EError;

public class BadRequestException extends RuntimeException {
    private final EError error;
    public BadRequestException(EError error) {
        super(error.getMessage());
        this.error = error;
    }
    public EError getError() {
        return error;
    }
}
