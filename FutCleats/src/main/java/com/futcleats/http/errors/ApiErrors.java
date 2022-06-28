package com.futcleats.http.errors;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    @Getter
    private String errors;

    public ApiErrors(String messageError){
        this.errors = messageError;
    }
}
