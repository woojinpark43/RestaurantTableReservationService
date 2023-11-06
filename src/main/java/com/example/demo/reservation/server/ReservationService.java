package com.example.demo.reservation.server;

import com.example.demo.partners.service.dto.RegisterInput;
import com.example.demo.reservation.dto.ReservationInput;
import com.example.demo.reservation.entity.Reservation;

public interface ReservationService {
    boolean register(String userName, String storeName, ReservationInput parameter);
    boolean checkKiosk(String kioskNum);
}
