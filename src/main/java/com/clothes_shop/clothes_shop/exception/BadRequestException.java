package com.clothes_shop.clothes_shop.exception;
import com.clothes_shop.clothes_shop.common.Error;

public class BadRequestException extends RuntimeException {
    private final Error error;
    public BadRequestException(Error error) {
        super(error.getMessage());
        this.error = error;
    }
    public Error getError() {
        return error;
    }
}
