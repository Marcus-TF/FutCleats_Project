package com.futcleats.http.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    @NotEmpty(message = "Informe o nome do produto.")
    private String name;

    @NotNull(message = "Informe a quantidade que está sendo adquirida.")
    private Integer quantidade;

    @NotNull(message = "Informe o valor do produto.")
    private BigDecimal value;
}
