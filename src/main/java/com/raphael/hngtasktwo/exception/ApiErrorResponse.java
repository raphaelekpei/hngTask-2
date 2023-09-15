package com.raphael.hngtasktwo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private String errorMessage;
    private boolean isSuccessful;
}
