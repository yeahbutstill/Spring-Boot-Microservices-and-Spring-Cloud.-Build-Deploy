package com.yeahbutstill.photoapp.api.users.exceptions;


import com.yeahbutstill.photoapp.api.users.model.response.ErrorMessageResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyExceptions(Exception e, WebRequest request) {

        String errorMessageDescription = e.getLocalizedMessage();
        if (errorMessageDescription == null) {
            errorMessageDescription = e.toString();
        }

        ErrorMessageResponseModel errorMessage = new ErrorMessageResponseModel(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = {NullPointerException.class, AuthenticationFilterException.class})
    public ResponseEntity<Object> handleSpecificExceptions(Exception e, WebRequest request) {

        return handleAnyExceptions(e, request);

    }

}
