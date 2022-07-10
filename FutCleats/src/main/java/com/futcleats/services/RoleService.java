package com.futcleats.services;

import com.futcleats.exception.RoleNotFoudException;
import com.futcleats.exception.UserNotFoundException;
import com.futcleats.model.RoleModel;
import com.futcleats.repository.RoleRepository;
import com.futcleats.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public List<RoleModel> findAll(){
        return roleRepository.findAll();
    }

    public RoleModel findById(UUID uuid){
        return roleRepository.findById(uuid).orElseThrow(() -> new RoleNotFoudException("Role não encontrada."));
    }

    public RoleModel save(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    public List<RoleModel> findRolesByUser(UUID uuid) {
        return roleRepository.findRoleModelByUserModel(userRepository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado.")));
    }
}
