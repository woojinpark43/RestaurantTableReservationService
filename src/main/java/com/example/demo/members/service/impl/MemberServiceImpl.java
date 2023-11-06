package com.example.demo.members.service.impl;

import com.example.demo.admin.model.MemberParam;
import com.example.demo.members.entity.Member;
import com.example.demo.members.repository.MemberRepository;
import com.example.demo.members.service.MemberService;
import com.example.demo.partners.service.dto.RegisterInput;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public boolean register(RegisterInput parameter) {
        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserName());
        if(optionalMember.isPresent()){
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        memberRepository.save(Member.builder()
                .userName(parameter.getUserName())
                .password(encPassword)
                .build());

        return true;
    }

    @Override
    public List<Member> list(MemberParam parameter) {
        if (parameter.getSearchType() == null || parameter.getSearchValue() == null
                || parameter.getSearchValue().equals("")) {
            return memberRepository.findAll();
        }

        return memberRepository.findByUserNameStartingWithIgnoreCase(parameter.getSearchValue());
    }

    @Override
    public List<Member> info(String userName) {
        return memberRepository.findByUserNameStartingWithIgnoreCase(userName);
    }
}
