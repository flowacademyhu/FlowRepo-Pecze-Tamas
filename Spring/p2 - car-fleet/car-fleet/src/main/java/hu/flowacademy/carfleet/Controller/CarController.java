package hu.flowacademy.carfleet.Controller;

import hu.flowacademy.carfleet.Domain.Car;
import hu.flowacademy.carfleet.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping()
    public ResponseEntity<List<Car>> listCars() {
        return ResponseEntity.ok(carService.listCars());
    }
    @PostMapping()
    public ResponseEntity<Car> addCars(@RequestBody Car car) {
        return ResponseEntity.ok(carService.addCars(car));
    }
    @GetMapping("/{CarRegId}")
    public ResponseEntity<List<Car>> findCarByRegId(@PathVariable String CarRegId) {
        return ResponseEntity.ok(carService.getCarByReg(CarRegId));
    }
}
