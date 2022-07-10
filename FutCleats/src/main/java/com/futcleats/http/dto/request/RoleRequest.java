package com.futcleats.http.dto.request;

import com.futcleats.model.enums.RoleStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
public class RoleRequest {

    @NotEmpty(message = "Informe a role.")
    private String name;

    private UUID idUser;
}
