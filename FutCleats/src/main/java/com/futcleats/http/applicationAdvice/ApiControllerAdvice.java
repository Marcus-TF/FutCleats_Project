package com.futcleats.http.applicationAdvice;

import com.futcleats.http.errors.ApiErrors;
import com.futcleats.services.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors HandleRegraNegocioException(UserNotFoundException e){
        String messageError = e.getMessage();
        return new ApiErrors(messageError);
    }
}
