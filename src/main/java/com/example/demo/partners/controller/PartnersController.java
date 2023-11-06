package com.example.demo.partners.controller;

import com.example.demo.Users.UserInput;
import com.example.demo.Users.UserService;
import com.example.demo.partners.entity.Partner;
import com.example.demo.partners.service.PartnerService;
import com.example.demo.partners.service.dto.RegisterInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PartnersController {

    private final PartnerService partnerService;
    private final UserService userService;

    @RequestMapping("/partner/login")
    public String login() { return "/login"; }

    @GetMapping("/partner/info")
    public String info(Model model, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        String username = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    // You've found the "username" cookie, and you can retrieve its value
                    username = cookie.getValue();
                }
            }
        }

        List<Partner> lst = partnerService.info(username);

        model.addAttribute("info", lst);

        return "/partner/info";
    }

    @GetMapping("/partner/index")
    public String index() { return "partner/index"; }

    @GetMapping("/partner/register")
    public String register() { return "partner/register"; }

    @PostMapping("/partner/register")
    public String registerSubmit(Model model, HttpServletResponse response
            , RegisterInput parameter) {
        boolean result = partnerService.register(parameter);

        UserInput userInput = new UserInput();
        userInput.convertRegisterInput(parameter, "partner");

        boolean C = userService.register(userInput);

        model.addAttribute("result", result);

        return "partner/register_complete";
    }

}
