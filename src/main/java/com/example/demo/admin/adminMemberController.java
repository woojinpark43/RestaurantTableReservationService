package com.example.demo.admin;

import com.example.demo.admin.dto.MemberDto;
import com.example.demo.admin.model.MemberParam;
import com.example.demo.partners.entity.Partner;
import com.example.demo.partners.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class adminMemberController {

    private final PartnerService partnerService;

    @GetMapping("/admin/partner/list")
    public String list(Model model, MemberParam parameter) {

        List<Partner> partners = partnerService.list(parameter);

        model.addAttribute("list", partners);

        return "/admin/partner/list";
    }
}
