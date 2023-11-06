package com.example.demo.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        // Your custom logic here
        // For example, you can store user-related information in a session or a database.

        // You can access user-related information from the authentication object:
        System.out.println("login success");
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60); // Set the cookie to expire in 24 hours
            response.addCookie(cookie);
            // Store user-related information or perform other actions.
        }
        response.sendRedirect("/");
    }
}
