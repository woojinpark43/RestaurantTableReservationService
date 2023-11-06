package com.example.demo.reservation.controller;

import com.example.demo.reservation.dto.ReservationInput;
import com.example.demo.reservation.server.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private String userName;
    private String storeName;

    @GetMapping("/reservation")
    public String reservation(HttpServletRequest request) {
        userName = request.getQueryString().split("-")[0];
        storeName = request.getQueryString().split("-")[1];
        return "reservation";
    }

    @PostMapping("/reservation")
    public String reservationSubmit(HttpServletRequest request, ReservationInput reservationInput) {
        System.out.println(userName);
        System.out.println(storeName);

        reservationService.register(userName, storeName, reservationInput);

        return "reservation_complete";
    }

    @RequestMapping("/reservation_complete")
    public String reservationComplete() {
        return "reservation/complete";
    }
}
