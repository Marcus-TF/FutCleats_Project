package com.futcleats.services;

import com.futcleats.model.UserModel;
import com.futcleats.repository.UserRepository;
import com.futcleats.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(UUID id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
    }

    public UserModel save(UserModel userModel) {
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    public UserModel update(UserModel userModel, UUID id) throws UserNotFoundException {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        userModel.setId(id);
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        userRepository.save(userModel);
        return userModel;
    }

    public UUID delete(UUID id) throws UserNotFoundException {
        UserModel usuario = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        userRepository.delete(usuario);
        return id;
    }

}
