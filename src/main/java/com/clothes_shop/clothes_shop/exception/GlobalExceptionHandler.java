package com.clothes_shop.clothes_shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException){
        GlobalException exception = new GlobalException(
                notFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException badRequestException){
        GlobalException exception = new GlobalException(
                badRequestException.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InternalSeverErrorException.class)
    public ResponseEntity<Object> handleInternalSeverErrorException(
             InternalSeverErrorException internalSeverErrorException){
        GlobalException exception = new GlobalException(
                internalSeverErrorException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
