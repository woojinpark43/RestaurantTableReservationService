package com.example.demo.members.service;

import com.example.demo.admin.model.MemberParam;
import com.example.demo.members.entity.Member;
import com.example.demo.partners.service.dto.RegisterInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService {
    boolean register(RegisterInput parameter);
    List<Member> list(MemberParam parameter);
    List<Member> info(String userName);
}
