package com.futcleats.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "users", schema = "project")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    private String login;

    private String cpf;

    private String telephone;

    private String email;

    private Date birthDate;

    private String password;

    @OneToMany(mappedBy = "userModel")
    private List<RoleModel> roleModelList;
}
