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
    @OneToMany(mappedBy = "driver")
    private List<Reservation> reservationsList;

    public Driver(String loginName, String password, String fullName, LocalDate licenceExpire, boolean isActive) {
        this.loginName = loginName;
        this.password = password;
        this.fullName = fullName;
        this.licenceExpire = licenceExpire;
        this.isActive = isActive;
    }

    public Driver() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getLicenceExpire() {
        return licenceExpire;
    }

    public void setLicenceExpire(LocalDate licenceExpire) {
        this.licenceExpire = licenceExpire;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
