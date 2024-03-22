package com.example.emtlab.MRSC.Service;


import com.example.emtlab.MRSC.Model.User;

public interface AuthService {
    User login(String username, String password);
}

