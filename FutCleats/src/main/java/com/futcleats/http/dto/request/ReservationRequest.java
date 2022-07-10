package com.futcleats.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futcleats.model.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ReservationRequest {

    @NotNull(message = "Informe o horário.")
    private Integer hour;

    @NotNull(message = "Informe a data.")
    private Date bookingDate;

    private UUID idUser;

    private UUID idField;

    private ReservationStatus reservationStatus;
}
