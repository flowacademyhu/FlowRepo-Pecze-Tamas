package hu.flowacademy.carfleet.Domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Driver {
    @Id
    @Column
    private String loginName;
    @Column
    private String password;
    @Column
    private String fullName;
    @Column
    private LocalDate licenceExpire;
    @Column
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "car_driver_id")
    private Car car;
    @OneToMany(mappedBy = "driver")
    private List<Reservation> reservationsList;

}
