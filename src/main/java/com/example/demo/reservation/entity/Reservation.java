package com.example.demo.reservation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservation")
@Builder
public class Reservation {
    @Id
    private String kioskNum;
    private String userName;
    private String storeName;
    private String reservationDate;
    private String reservationTime;
}
