package com.blazingpotato.securityapp;

import com.blazingpotato.securityapp.domain.Role;
import com.blazingpotato.securityapp.domain.User;
import com.blazingpotato.securityapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityappApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Jhon Cena", "jhon", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "The Rock", "rock", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Mario its a me a", "mario", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jhon Xena", "bc", "1234", new ArrayList<>()));

            userService.addRoleToUser("jhon", "ROLE_USER");
            userService.addRoleToUser("rock", "ROLE_USER");
            userService.addRoleToUser("rock", "ROLE_ADMIN");
            userService.addRoleToUser("mario", "ROLE_USER");
            userService.addRoleToUser("mario", "ROLE_MANAGER");
            userService.addRoleToUser("mario", "ROLE_ADMIN");
            userService.addRoleToUser("mario", "ROLE_SUPER_ADMIN");
        };
    }
}
