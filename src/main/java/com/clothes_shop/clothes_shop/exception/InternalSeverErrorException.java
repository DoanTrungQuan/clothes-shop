package com.clothes_shop.clothes_shop.exception;

import com.clothes_shop.clothes_shop.common.Error;

public class InternalSeverErrorException extends java.lang.Error {
    private final Error error;
    public InternalSeverErrorException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
