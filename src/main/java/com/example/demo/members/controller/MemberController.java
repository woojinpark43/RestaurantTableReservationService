package com.example.demo.members.controller;

import com.example.demo.Users.UserInput;
import com.example.demo.Users.UserService;
import com.example.demo.members.entity.Member;
import com.example.demo.members.service.MemberService;
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
public class MemberController {

    private final MemberService memberService;
    private final UserService userService;

//    @RequestMapping("/member/login")
//    public String login() { return "/login"; }

    @GetMapping("/member/info")
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

        List<Member> lst = memberService.info(username);

        model.addAttribute("info", lst);

        return "/member/info";
    }

    @GetMapping("/member/index")
    public String index() { return "member/index"; }

    @GetMapping("/member/register")
    public String register() { return "member/register"; }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletResponse response
            , RegisterInput parameter) {
        boolean result = memberService.register(parameter);

        UserInput userInput = new UserInput();
        userInput.convertRegisterInput(parameter, "member");

        boolean C = userService.register(userInput);

        model.addAttribute("result", result);

        return "member/register_complete";
    }
}
