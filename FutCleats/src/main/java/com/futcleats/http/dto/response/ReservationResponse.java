package com.futcleats.http.dto.response;

import com.futcleats.model.enums.ReservationStatus;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReservationResponse {

    private UUID id;

    private Integer hour;

    private Date bookingDate;

    private ReservationStatus reservationStatus;

    private String nameUser;

    private UUID idUser;

    private String nameField;

    private UUID idField;

}
