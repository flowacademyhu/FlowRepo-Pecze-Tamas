package hu.flowacademy.carfleet.Repositories;

import hu.flowacademy.carfleet.Domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
