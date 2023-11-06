package com.example.demo.Users;

import com.example.demo.partners.service.dto.RegisterInput;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserInput {
    private String userName;
    private String  password;
    private String type;
    private boolean adminYn;

    public void convertRegisterInput(RegisterInput parameter, String type){
        this.userName = parameter.getUserName();
        this.password = parameter.getPassword();
        this.adminYn = false;
        this.type = type;
    }
}
