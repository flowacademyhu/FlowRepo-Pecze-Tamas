package hu.flowacademy.carfleet.Service;
import hu.flowacademy.carfleet.Domain.Driver;
import hu.flowacademy.carfleet.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }
    public void delete(String id) {
        try {
            driverRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {

        }
    }
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }
    public Driver getOneDriver(String id) {
        if(driverRepository.findById(id).isPresent()) {
            return driverRepository.findById(id).get();
        }
        throw new Error();
    }
}
