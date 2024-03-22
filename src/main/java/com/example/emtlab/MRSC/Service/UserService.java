package com.example.emtlab.MRSC.Service;

import com.example.emtlab.Enumerations.Role;
import com.example.emtlab.MRSC.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> register(String username, String password, String repeatPassword, String name, String surname, Role userRole);
}
