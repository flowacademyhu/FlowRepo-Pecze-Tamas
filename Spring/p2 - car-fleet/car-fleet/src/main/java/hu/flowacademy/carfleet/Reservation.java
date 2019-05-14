package hu.flowacademy.carfleet;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "car_id")
    private Car car;
    //@ManyToOne
    //@JoinColumn(name = "reservation_driver")
    //private Driver reservation;

}
