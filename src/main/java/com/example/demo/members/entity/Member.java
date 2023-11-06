package com.example.demo.members.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "member")
@Builder
public class Member {
    @Id
    private String userName;
    private String password;
    private boolean adminYn;
}
