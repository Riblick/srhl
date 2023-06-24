package com.example.riblick.Service;

import com.example.riblick.Entity.Role;
import com.example.riblick.Entity.User;
import com.example.riblick.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public boolean createUser(User user) {
        String username = user.getUsername();

        if (userRepository.findByUsername(username) != null) {
            return false;

        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.getRoles().add(Role.STUDENT);
        user.getRoles().add(Role.ADMIN);

        userRepository.save(user);
        log.info("Saving new user with username: {}", username);
        return true;


    }
}
