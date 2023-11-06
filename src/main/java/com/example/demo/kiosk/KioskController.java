package com.example.demo.kiosk;

import com.example.demo.reservation.server.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class KioskController {

    private final ReservationService reservationService;

    @GetMapping("/kiosk")
    public String kiosk(HttpServletRequest request) {
        return "kiosk";
    }

    @PostMapping("/kiosk")
    public String kioskSubmit(@RequestParam("searchValue") String searchValue, Model model) {

        System.out.println(searchValue);
        Boolean result = reservationService.checkKiosk(searchValue);

        model.addAttribute("result", result);

        if (!result) {
            return "kiosk";
        }

        return "kiosk_complete";
    }
}
