package com.example.demo;

import com.example.demo.partners.entity.Partner;
import com.example.demo.partners.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final PartnerService partnerService;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {

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

        boolean result = false;

        if(!username.equals("")) {
            result = true;
        }


        List<Partner> info = partnerService.getAllRestaurantsExceptAdmin();

        model.addAttribute("info", info);
        model.addAttribute("result", result);
        model.addAttribute("username", username);

        return "Index";
    }

    @RequestMapping("/login")
    public String login() { return "/login"; }

    @RequestMapping("/error/denied")
    public String error() {
        return "/error/denied";
    }
}
