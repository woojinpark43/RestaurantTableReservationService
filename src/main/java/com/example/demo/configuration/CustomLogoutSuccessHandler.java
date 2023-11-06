package com.example.demo.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        Cookie cookie = new Cookie("username", "");
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // Set the cookie to expire in 24 hours
        response.addCookie(cookie);
        response.sendRedirect("/");
    }
}
