package hu.flowacademy.carfleet.Exception;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(String id) {
        super("Driver was not found ( ID name: " + id + " )");
    }
}
