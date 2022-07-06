package com.futcleats.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {

    private UUID uuid;

    private String name;

    private Integer quantidade;

    private BigDecimal value;
}
