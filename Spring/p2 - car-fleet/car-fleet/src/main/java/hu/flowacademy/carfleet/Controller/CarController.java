package hu.flowacademy.carfleet.Controller;

import hu.flowacademy.carfleet.Domain.Car;
import hu.flowacademy.carfleet.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping()
    public ResponseEntity<List<Car>> listDrivers() {
        return ResponseEntity.ok(carService.listCars());
    }
}
