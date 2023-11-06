package com.example.demo.Users;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean register(UserInput parameter);
}
