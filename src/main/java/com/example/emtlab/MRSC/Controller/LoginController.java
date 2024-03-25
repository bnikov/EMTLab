package com.example.emtlab.MRSC.Controller;

import com.example.emtlab.MRSC.Model.User;
import com.example.emtlab.MRSC.Service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @PostMapping
    public User login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        User user = null;

        user = this.authService.login(username, password);
        request.getSession().setAttribute("user", user);

        return user;
    }
}
