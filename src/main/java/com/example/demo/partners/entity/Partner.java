package com.example.demo.partners.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "partner")
@Builder
public class Partner {

    @Id
    private String userName;
    private String password;
    private String storeName;
    private String location;
    private String description;
    private boolean adminYn;
}
