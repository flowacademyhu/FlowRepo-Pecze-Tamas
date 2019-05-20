package hu.flowacademy.carfleet.Repositories;

import hu.flowacademy.carfleet.Domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    List<Car> findCarByregistrationNumber(String registrationNumber);
}
