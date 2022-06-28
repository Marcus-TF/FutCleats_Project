package com.futcleats.http.dto.response;

import com.futcleats.model.enums.RoleStatus;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserRoleResponse {

    private Long idUser;

    private List<RoleStatus> roleStatusLists;
}
