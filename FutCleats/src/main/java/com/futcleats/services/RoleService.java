package com.futcleats.services;

import com.futcleats.http.dto.response.CreateUserRoleResponse;
import com.futcleats.model.RoleModel;
import com.futcleats.model.UserModel;
import com.futcleats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private UserRepository userRepository;

    public UserModel execute(CreateUserRoleResponse createUserRoleResponse) {

        Optional<UserModel> userExist = userRepository.findById(createUserRoleResponse.getIdUser());
        List<RoleModel> roleModelList = new ArrayList<>();

        if (userExist.isEmpty()) {
            throw new Error("Usuário não encontrado.");
        } else {

            roleModelList = createUserRoleResponse.getRoleStatusLists().stream().map(role -> {
                return new RoleModel(role);
            }).collect(Collectors.toList());
        }

        UserModel userModel = userExist.get();

        userModel.setRoleModelList(roleModelList);

        userRepository.save(userModel);
        return userModel;
    }
}
