package com.futcleats.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class FieldRequest {

    @NotEmpty(message = "Informe o nome ou apelido do campo.")
    private String name;

    private UUID codCategory;
}
