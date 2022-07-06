package com.futcleats.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "field", schema = "project")
public class FieldModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "fieldModel")
    private List<ReservationModel> reservationModelList;

    @ManyToOne
    @JoinColumn(name = "cod_categoryCod")
    private CategoryModel categoryModel;
}
