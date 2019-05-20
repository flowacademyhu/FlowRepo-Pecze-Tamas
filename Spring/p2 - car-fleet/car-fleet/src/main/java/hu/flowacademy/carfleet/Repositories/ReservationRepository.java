package hu.flowacademy.carfleet.Repositories;

import hu.flowacademy.carfleet.Domain.Car;
import hu.flowacademy.carfleet.Domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
