package com.futcleats.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futcleats.model.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ReservationRequest {

    @NotNull(message = "Informe o horário.")
    private Integer hour;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull(message = "Informe a data.")
    private LocalDateTime bookingDate;

    private UUID idUser;

    private UUID idField;

    private ReservationStatus reservationStatus;
}
