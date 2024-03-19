package com.team6.academigymraeg.security;


import com.team6.academigymraeg.model.User;
import com.team6.academigymraeg.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FirstUserConfigurer {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public FirstUserConfigurer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setup() {
        if (userRepository.countByUsername("admin") < 1) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPasswordHash(passwordEncoder.encode("admin"));
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
        }
    }
}
