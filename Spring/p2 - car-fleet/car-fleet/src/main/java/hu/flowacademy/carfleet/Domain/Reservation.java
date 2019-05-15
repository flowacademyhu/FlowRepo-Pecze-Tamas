package hu.flowacademy.carfleet.Domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @Column
    private int id;
    @Column
    private LocalDateTime returnDate;
    @Column
    private LocalDate endOfReservation;
    @Column
    private String JourneyDesc;
    @Column
    private String driver;
    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "driver_reservation")
    private Driver reservation;

}
