package com.example.demo.members.repository;

import com.example.demo.members.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByUserNameStartingWithIgnoreCase(String val);
}
