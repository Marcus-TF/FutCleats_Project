package com.futcleats.model;

import com.futcleats.model.enums.RoleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "role", schema = "project")
public class RoleModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private RoleStatus roleStatus = RoleStatus.USER;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel userModel;

    public RoleModel(RoleStatus roleStatus) {
        this.roleStatus = roleStatus;
    }
}
