package com.example.demo.reservation.server.impl;

import com.example.demo.partners.entity.Partner;
import com.example.demo.reservation.dto.ReservationInput;
import com.example.demo.reservation.entity.Reservation;
import com.example.demo.reservation.repository.ReservationRepository;
import com.example.demo.reservation.server.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class reservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public boolean register(String userName, String storeName, ReservationInput parameter) {
        // Create a random number generator
        Random random = new Random();

        // Generate a random 6-digit number
        int randomNumber = 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999

        // Convert the number to a string
        String kiosk = Integer.toString(randomNumber);

        Optional<Reservation> optionalMember = reservationRepository.findById(kiosk);
        if(optionalMember.isPresent()){
            return false;
        }


        reservationRepository.save(Reservation.builder()
                .storeName(storeName)
                .userName(userName)
                .reservationDate(parameter.getReservationDate())
                .reservationTime(parameter.getReservationTime())
                .kioskNum(kiosk).build());

        return true;
    }

    @Override
    public boolean checkKiosk(String kioskNum) {

        Optional<Reservation> optionalKiosk = reservationRepository.findById(kioskNum);
        if(optionalKiosk.isEmpty()){
            return false;
        }
        return true;
    }
}
