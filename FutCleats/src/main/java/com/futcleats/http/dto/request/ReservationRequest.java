package com.futcleats.http.dto.request;

import com.futcleats.model.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ReservationRequest {

    @NotNull(message = "Informe o horário.")
    private Integer hour;

    @NotNull(message = "Informe a data.")
    private Date bookingDate;

    private Long idUser;

    private Long idField;

    private ReservationStatus reservationStatus;
}
