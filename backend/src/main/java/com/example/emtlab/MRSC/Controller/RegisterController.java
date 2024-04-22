package com.example.emtlab.MRSC.Controller;

import com.example.emtlab.Enumerations.Role;
import com.example.emtlab.Exceptions.InvalidArgumentsException;
import com.example.emtlab.Exceptions.PasswordsDoNotMatchException;
import com.example.emtlab.MRSC.Model.User;
import com.example.emtlab.MRSC.Service.AuthService;
import com.example.emtlab.MRSC.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> register(@RequestParam String username,
                                         @RequestParam String password,
                                         @RequestParam String repeatedPassword,
                                         @RequestParam String name,
                                         @RequestParam String surname,
                                         @RequestParam Role role) {
        return userService.register(username, password, repeatedPassword, name, surname, role)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseThrow(RuntimeException::new);
    }
}

