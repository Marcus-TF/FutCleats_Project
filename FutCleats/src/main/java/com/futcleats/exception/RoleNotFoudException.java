package com.futcleats.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RoleNotFoudException extends RuntimeException{

    public RoleNotFoudException(String message){
        super(message);
    }
}
