package com.ortiz.jonathan.security.service;

import com.ortiz.jonathan.security.model.User;
import com.ortiz.jonathan.security.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(String username, String password, String role) {
        User user = new User(username, passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }
}
