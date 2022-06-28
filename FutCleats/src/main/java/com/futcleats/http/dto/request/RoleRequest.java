package com.futcleats.http.dto.request;

import com.futcleats.model.enums.RoleStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest {

    private String name;

    private RoleStatus roleStatus;
}
