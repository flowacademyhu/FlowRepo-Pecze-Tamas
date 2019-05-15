package hu.flowacademy.carfleet.Controller;

import hu.flowacademy.carfleet.Domain.Reservation;
import hu.flowacademy.carfleet.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping
    public ResponseEntity<List<Reservation>> listReservations() {
        return ResponseEntity.ok(reservationService.listAllReservation());
    }
    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation r) {
        return ResponseEntity.ok(reservationService.saveReservation(r));
    }
}
