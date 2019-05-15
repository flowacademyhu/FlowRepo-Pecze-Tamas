package hu.flowacademy.carfleet.Service;

import hu.flowacademy.carfleet.Domain.Reservation;
import hu.flowacademy.carfleet.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> listAllReservation() {
        return reservationRepository.findAll();
    }
}
