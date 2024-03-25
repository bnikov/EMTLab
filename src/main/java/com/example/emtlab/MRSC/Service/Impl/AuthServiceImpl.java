package com.example.emtlab.MRSC.Service.Impl;

import com.example.emtlab.Exceptions.InvalidArgumentsException;
import com.example.emtlab.Exceptions.InvalidUserCredentialsException;
import com.example.emtlab.MRSC.Model.User;
import com.example.emtlab.MRSC.Repository.UserRepository;
import com.example.emtlab.MRSC.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        System.out.println(username);
        System.out.println(password);
        System.out.println(passwordEncoder.encode(password));


//        return userRepository.findUserByUsernameAndPassword(username, passwordEncoder.encode(password))
//                .orElseThrow(InvalidUserCredentialsException::new);

        User user = userRepository.findByUsername(username)
                .orElseThrow(RuntimeException::new);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException();
        }
        return user;
    }

}

