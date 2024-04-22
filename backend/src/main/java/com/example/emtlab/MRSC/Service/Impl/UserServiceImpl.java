package com.example.emtlab.MRSC.Service.Impl;

import com.example.emtlab.Enumerations.Role;
import com.example.emtlab.Exceptions.InvalidUsernameOrPasswordException;
import com.example.emtlab.Exceptions.PasswordsDoNotMatchException;
import com.example.emtlab.Exceptions.UsernameAlreadyExistsException;
import com.example.emtlab.MRSC.Model.User;
import com.example.emtlab.MRSC.Repository.UserRepository;
import com.example.emtlab.MRSC.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public Optional<User> register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setSurname(surname);
        user.setRole(userRole);
        return Optional.of(userRepository.save(user));
    }

}
