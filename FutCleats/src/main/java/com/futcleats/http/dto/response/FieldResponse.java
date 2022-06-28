package com.futcleats.http.dto.response;

import com.futcleats.config.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldResponse {

    private Long id;

    private String name;

    @NotEmptyList(message = "Tem que haver horários cadastrados no campo!")
    private List<ReservationResponse> reservationResponseList;
}
