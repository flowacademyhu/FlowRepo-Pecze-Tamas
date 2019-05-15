package hu.flowacademy.carfleet.Service;

import hu.flowacademy.carfleet.Domain.Car;
import hu.flowacademy.carfleet.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> listCars() {
        return carRepository.findAll();
    }
}
