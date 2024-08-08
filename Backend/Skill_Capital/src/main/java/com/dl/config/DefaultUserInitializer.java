package com.dl.config;

import com.dl.model.Role;
import com.dl.model.User;
import com.dl.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DefaultUserInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initDefaultUser() {
        return args -> {
            // Check if the default user exists
            if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
                // Create and save the default user
                User defaultUser = new User();
                defaultUser.setEmail("admin@gmail.com");
                defaultUser.setPassword(passwordEncoder.encode("admin123"));
                defaultUser.setRole(Role.ADMIN);
                defaultUser.setName("Default Admin");
                

                userRepository.save(defaultUser);
                System.out.println("Default admin user added to the database.");
            }
        };
    }
}
