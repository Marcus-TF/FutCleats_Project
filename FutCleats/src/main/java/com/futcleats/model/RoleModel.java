package com.futcleats.model;

import com.futcleats.model.enums.RoleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "role", schema = "project")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private RoleStatus roleStatus = RoleStatus.USER;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel userModel;

    public RoleModel(RoleStatus roleStatus) {
        this.roleStatus = roleStatus;
    }
}
