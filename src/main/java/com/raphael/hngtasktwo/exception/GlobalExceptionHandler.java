package com.raphael.hngtasktwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> PersonNotFoundExceptionHandler(PersonNotFoundException personNotFoundException){
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .errorMessage(personNotFoundException.getMessage())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }
}
