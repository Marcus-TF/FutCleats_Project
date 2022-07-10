package com.futcleats.http.controller;

import com.futcleats.http.dto.request.RoleRequest;
import com.futcleats.http.dto.response.RoleResponse;
import com.futcleats.http.mapper.RoleMapper;
import com.futcleats.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
@Validated
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleResponse> save(@RequestBody @Valid RoleRequest roleRequest) {
        return ResponseEntity.ok().body(RoleMapper.toResponse(roleService.save(RoleMapper.toModel(roleRequest))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleResponse>> findAll() {
        return ResponseEntity.ok().body(RoleMapper.roleResponseList(roleService.findAll()));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleResponse> findById(@PathVariable String roleId) {
        return ResponseEntity.ok().body(RoleMapper.toResponse(roleService.findById(UUID.fromString(roleId))));
    }

    @GetMapping("/findRolesByUser/{userId}")
    public ResponseEntity<List<RoleResponse>> findRolesByUser(@PathVariable String userId) {
        return ResponseEntity.ok().body(RoleMapper.roleResponseList(roleService.findRolesByUser(UUID.fromString(userId))));
    }
}
