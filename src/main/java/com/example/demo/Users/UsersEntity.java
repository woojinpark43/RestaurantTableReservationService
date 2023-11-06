package com.example.demo.Users;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Builder
public class UsersEntity {

    @Id
    private String userName;
    private String password;
    private String type;
    private boolean adminYn;
}
