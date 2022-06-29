package com.futcleats.services;

import com.futcleats.model.UserModel;
import com.futcleats.repository.UserRepository;
import com.futcleats.services.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
                .orElseThrow(() -> new UserNotFoundException());
    }

    public UserModel save(UserModel userModel) {
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    public UserModel update(UserModel userModel, UUID id) throws UserNotFoundException {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        userModel.setId(id);
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        userRepository.save(userModel);
        return userModel;
    }

    public UUID delete(UUID id) throws UserNotFoundException {
        UserModel usuario = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(usuario);
        return id;
    }

}
