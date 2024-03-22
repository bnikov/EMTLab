package com.example.emtlab.MRSC.Service.Impl;

import com.example.emtlab.Exceptions.InvalidArgumentsException;
import com.example.emtlab.Exceptions.InvalidUserCredentialsException;
import com.example.emtlab.MRSC.Model.User;
import com.example.emtlab.MRSC.Repository.UserRepository;
import com.example.emtlab.MRSC.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}

