package hu.flowacademy.carfleet.Repositories;

import hu.flowacademy.carfleet.Domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,String> {

}
