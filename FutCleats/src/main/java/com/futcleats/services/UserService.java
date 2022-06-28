package com.futcleats.services;

import com.futcleats.model.UserModel;
import com.futcleats.repository.UserRepository;
import com.futcleats.services.exception.RegraNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    public UserModel findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
    }

    public UserModel save(UserModel userModel) {
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    public UserModel upDate(UserModel userModel, UUID id) {
        userRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
        userModel.setId(id);
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        userRepository.save(userModel);
        return userModel;
    }

    public UUID delete(UUID id) {
        UserModel usuario = userRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
        userRepository.delete(usuario);
        return id;
    }

}
