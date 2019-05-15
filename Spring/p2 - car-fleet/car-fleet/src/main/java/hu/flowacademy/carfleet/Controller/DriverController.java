package hu.flowacademy.carfleet.Controller;

import hu.flowacademy.carfleet.Domain.Driver;
import hu.flowacademy.carfleet.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping()
    public ResponseEntity<List<Driver>> listDriver() {
        return ResponseEntity.ok(driverService.listDrivers());
    }


}
