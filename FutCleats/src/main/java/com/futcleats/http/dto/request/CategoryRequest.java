package com.futcleats.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class CategoryRequest {

    @NotEmpty(message = "Informe o nome da categoria.")
    private String category;
}
