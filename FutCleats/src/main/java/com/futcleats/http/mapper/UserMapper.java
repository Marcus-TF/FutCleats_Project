package com.futcleats.http.mapper;

import com.futcleats.http.dto.request.UserRequest;
import com.futcleats.http.dto.response.UserResponse;
import com.futcleats.model.FieldModel;
import com.futcleats.model.ReservationModel;
import com.futcleats.model.RoleModel;
import com.futcleats.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class UserMapper {

    public static UserModel toModel(UserRequest request){
        return UserModel.builder()
                .name(request.getName())
                .login(request.getLogin())
                .cpf(request.getCpf())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .password(request.getPassword())
                .build();
    }

    public static UserResponse toResponse(UserModel userModel){
        return UserResponse.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .login(userModel.getLogin())
                .cpf(userModel.getCpf())
                .telephone(userModel.getTelephone())
                .email(userModel.getEmail())
                .birthDate(userModel.getBirthDate())
                .password(userModel.getPassword())
                .build();
    }

    public static List<UserResponse> toResponseList(List<UserModel> userModelList){
        if(isNull(userModelList) || userModelList.isEmpty()){
            return new ArrayList<>();
        } else {
            return userModelList.stream().map(UserMapper::toResponse).collect(Collectors.toList());
        }
    }

}
