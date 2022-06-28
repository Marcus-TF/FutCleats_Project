package com.futcleats.http.dto.response;

import com.futcleats.model.enums.RoleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoleResponse {

    private Long id;

    private RoleStatus roleStatus;
}
