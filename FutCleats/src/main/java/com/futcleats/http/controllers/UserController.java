package com.futcleats.http.controllers;

import com.futcleats.http.dto.response.CreateUserRoleResponse;
import com.futcleats.http.dto.request.UserRequest;
import com.futcleats.http.dto.response.UserResponse;
import com.futcleats.http.mapper.UserMapper;
import com.futcleats.model.UserModel;
import com.futcleats.services.RoleService;
import com.futcleats.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Validated
@Api
public class UserController {

    private final UserService userService;

    @Autowired
    private final RoleService roleService;

    @GetMapping("/all")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna a lista de usuários"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Não existe usuários."),
    })
    public ResponseEntity<List<UserResponse>> findALL(){
        return ResponseEntity.ok().body(UserMapper.toResponseList(userService.findAll()));
    }

    @GetMapping("/{userId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna um usuário."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 404, message = "Não existe um usuário com esse id."),
    })
    public ResponseEntity<UserResponse> findByID(@PathVariable String userId){
        return ResponseEntity.ok().body(UserMapper.toResponse(userService.findById(Long.valueOf(userId))));
    }
    @PostMapping
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário salvo com sucesso."),
            @ApiResponse(code = 403, message = "Requisição informada inválida."),
    })
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(UserMapper.toResponse(userService.save(UserMapper.toModel(userRequest))));
    }
    @PutMapping("/{userId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso."),
            @ApiResponse(code = 400, message = "Requisição informada inválida."),
    })
    public ResponseEntity<UserResponse> upDate(@PathVariable String userId, @Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(UserMapper.toResponse(userService.upDate(UserMapper.toModel(userRequest), Long.valueOf(userId))));
    }
    @DeleteMapping("/{userId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuário deletado com sucesso."),
            @ApiResponse(code = 404, message = "Não existe um usuário com esse id."),
    })
    public ResponseEntity<Long> delete(@PathVariable String userId){
        return ResponseEntity.ok().body(userService.delete(Long.valueOf(userId)));
    }

    @PostMapping("/role")
    public UserModel role(@RequestBody CreateUserRoleResponse createUserRoleResponse){
        return roleService.execute(createUserRoleResponse);
    }

}
