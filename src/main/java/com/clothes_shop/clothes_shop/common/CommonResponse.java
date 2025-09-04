package com.clothes_shop.clothes_shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private String message;
    private int status;
    private T data;

    public CommonResponse(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static <T> CommonResponse<T> response(String message, int status, T data) {
        return new CommonResponse<>(
                message,
                status,
                data
        );
    }

    public static CommonResponse<Void> response(String message, int status) {
        return new CommonResponse<>(
                message,
                status,
                null
        );
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
