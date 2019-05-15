package hu.flowacademy.carfleet.Domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Car")
public class Car {

    @Id
    @Column
    private String registrationNumber;
    @Column
    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;
    @Column
    private String manufacturer;
    @Column
    private String type;
    @Column
    private int yearsOfManufacturing;
    @Column
    private LocalDate timeOfExpire;

    public Car(String registrationNumber, String manufacturer, String type, int yearsOfManufacturing, LocalDate timeOfExpire) {
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.type = type;
        this.yearsOfManufacturing = yearsOfManufacturing;
        this.timeOfExpire = timeOfExpire;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearsOfManufacturing() {
        return yearsOfManufacturing;
    }

    public void setYearsOfManufacturing(int yearsOfManufacturing) {
        this.yearsOfManufacturing = yearsOfManufacturing;
    }

    public LocalDate getTimeOfExpire() {
        return timeOfExpire;
    }

    public void setTimeOfExpire(LocalDate timeOfExpire) {
        this.timeOfExpire = timeOfExpire;
    }

}
