package com.futcleats.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FieldRequest {

    @NotEmpty(message = "Informe o nome ou apelido do campo.")
    private String name;
}
