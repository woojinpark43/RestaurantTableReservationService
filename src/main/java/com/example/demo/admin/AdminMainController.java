package com.example.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {

    @GetMapping("/admin/main")
    public String main() {
        return "admin/main";
    }

}
