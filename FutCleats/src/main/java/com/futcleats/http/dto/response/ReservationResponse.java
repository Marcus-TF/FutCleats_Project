package com.futcleats.http.dto.response;

import com.futcleats.model.enums.ReservationStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReservationResponse {

    private UUID id;

    private Integer hour;

    private Date bookingDate;

    private ReservationStatus reservationStatus;

    private String nameUser;

    private String nameField;
}
