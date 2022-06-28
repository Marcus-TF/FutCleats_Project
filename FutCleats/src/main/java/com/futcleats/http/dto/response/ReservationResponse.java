package com.futcleats.http.dto.response;

import com.futcleats.model.enums.ReservationStatus;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReservationResponse {

    private Long id;

    private Integer hour;

    private Date bookingDate;

    private ReservationStatus reservationStatus;

    private String nameUser;

    private Long idUser;

    private String nameField;

    private Long idField;

}
