package com.clothes_shop.clothes_shop.exception;

import com.clothes_shop.clothes_shop.common.EError;

public class InternalSeverErrorException extends Error{
    private final EError error;
    public InternalSeverErrorException(EError error) {
        super(error.getMessage());
        this.error = error;
    }

    public EError getError() {
        return error;
    }
}
