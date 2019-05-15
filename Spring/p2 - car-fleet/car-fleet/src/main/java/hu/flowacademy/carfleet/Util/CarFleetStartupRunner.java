package hu.flowacademy.carfleet.Util;

import hu.flowacademy.carfleet.Domain.Car;
import hu.flowacademy.carfleet.Domain.Driver;
import hu.flowacademy.carfleet.Repositories.CarRepository;
import hu.flowacademy.carfleet.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class CarFleetStartupRunner implements CommandLineRunner {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;
    @Override
    public void run(String... args) throws Exception {
        LocalDate ld1 = LocalDate.of(2019, Month.DECEMBER, 25);
        LocalDate ld2 = LocalDate.of(1992,Month.JULY,30);
        LocalDate ld3 = LocalDate.of(1993,Month.JULY,20);
        LocalDate ld4 = LocalDate.of(2020,Month.MAY,10);
        Car car1 = new Car("SA023XX","Seat","Ibiza",2001,ld1);
        Car car2 = new Car("KI031AA","Ford","Focus",2011,ld4);
        Driver driver1 = new Driver("Poczok","lovePushing","Pecze Tamas",ld2,true);
        Driver driver2 = new Driver("Andor1993","lovejava007","Hajnal Andor",ld3,true);
        driverRepository.save(driver1);
        driverRepository.save(driver2);
        carRepository.save(car1);
        carRepository.save(car2);
    }
}
