package hu.flowacademy.carfleet.Repositories;

import hu.flowacademy.carfleet.Domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {

}
