package com.example.demo.partners.service.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class RegisterInput {

    private String storeName;
    private String location;
    private String userName;
    private String  password;
    private String description;
    private Boolean admin_yn;
}
