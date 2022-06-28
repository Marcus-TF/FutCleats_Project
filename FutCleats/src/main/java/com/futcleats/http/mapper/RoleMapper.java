package com.futcleats.http.mapper;

import com.futcleats.http.dto.request.RoleRequest;
import com.futcleats.http.dto.response.RoleResponse;
import com.futcleats.model.RoleModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class RoleMapper {

    public static RoleModel toModel(RoleRequest roleRequest){
        return RoleModel.builder()
                .roleStatus(roleRequest.getRoleStatus())
                .build();
    }

    public static RoleResponse toResponse(RoleModel roleModel){
        return RoleResponse.builder()
                .id(roleModel.getId())
                .roleStatus(roleModel.getRoleStatus())
                .build();
    }

    public static List<RoleResponse> roleResponseList(List<RoleModel> roleModelList){
        if(isNull(roleModelList) || roleModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return roleModelList.stream().map(RoleMapper::toResponse).collect(Collectors.toList());
        }
    }
}
