package com.example.demo.reservation.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ReservationInput {
    private String reservationDate;
    private String reservationTime;
}
