package com.clothes_shop.clothes_shop.exception;

import com.clothes_shop.clothes_shop.common.EError;

public class NotFoundException extends RuntimeException {
    private final EError error;
    public NotFoundException(EError error) {
        super(error.getMessage());
        this.error = error;
    }

    public EError getError() {
        return error;
    }
}
