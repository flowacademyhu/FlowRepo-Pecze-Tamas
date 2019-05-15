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
    @ManyToOne
    @JoinColumn(name = "car_Id", foreignKey = @ForeignKey(name = "fk_car_reservation") )
    private Car car;
    @ManyToOne
    @JoinColumn(name = "driver_id", foreignKey = @ForeignKey(name = "fk_driver_reservation"))
    private Driver driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getEndOfReservation() {
        return endOfReservation;
    }

    public void setEndOfReservation(LocalDate endOfReservation) {
        this.endOfReservation = endOfReservation;
    }

    public String getJourneyDesc() {
        return JourneyDesc;
    }

    public void setJourneyDesc(String journeyDesc) {
        JourneyDesc = journeyDesc;
    }

    public Reservation() {
    }
}
