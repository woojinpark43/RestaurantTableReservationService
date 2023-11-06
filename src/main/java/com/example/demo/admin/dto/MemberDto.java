package com.example.demo.admin.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String userName;
    private String password;
    private String storeName;
    private String location;
    private String description;
    private boolean adminYn;
}
