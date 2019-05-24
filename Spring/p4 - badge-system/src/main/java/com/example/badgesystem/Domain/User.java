package com.example.badgesystem.Domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    public User() {
    }
    @Column
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String username;

    @Column
    private String fullname;

    @Column
    private String password;

    @Column
    private String role;

    @ManyToOne
    @JoinColumn(name = "badge_id", foreignKey = @ForeignKey(name = "fk_badge_id"))
    private User user;

    public User(String username, String fullname, String password, String role) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }
}
