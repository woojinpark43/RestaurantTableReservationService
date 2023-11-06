package com.example.demo.members.service.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class RegisterInput {
    private String userName;
    private String  password;
    private boolean adminYn;
}
