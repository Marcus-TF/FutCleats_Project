package com.futcleats.http.applicationAdvice;

import com.futcleats.http.errors.ApiErrors;
import com.futcleats.services.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors HandleRegraNegocioException(RegraNegocioException e){
        String messageError = e.getMessage();
        return new ApiErrors(messageError);
    }
}
