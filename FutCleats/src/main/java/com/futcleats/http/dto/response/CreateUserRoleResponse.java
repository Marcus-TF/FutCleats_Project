package com.futcleats.http.dto.response;

import com.futcleats.model.enums.RoleStatus;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateUserRoleResponse {

    private UUID idUser;

    private List<RoleStatus> roleStatusLists;
}
