package com.futcleats.model;

import com.futcleats.model.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation", schema = "project")
public class ReservationModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer hour;

    private Date bookingDate;

    private ReservationStatus reservationStatus = ReservationStatus.OPENED;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "id_field")
    private FieldModel fieldModel;

}
