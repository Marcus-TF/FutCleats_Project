package com.futcleats.http.dto.response;

import com.futcleats.model.enums.RoleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoleResponse {

    private UUID id;

    private RoleStatus roleStatus;
}
