package com.futcleats.repository;

import com.futcleats.model.RoleModel;
import com.futcleats.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, UUID> {

    List<RoleModel> findRoleModelByUserModel(UserModel userModel);
}
