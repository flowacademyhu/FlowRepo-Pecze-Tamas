package hu.flowacademy.carfleet;

import hu.flowacademy.carfleet.Domain.Car;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.Month;

public class CarFleetStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        LocalDate ld1 = LocalDate.of(2019, Month.DECEMBER, 25);
        Car car1 = new Car("SA023XX","Seat","Ibiza",2001,ld1);
    }
}
