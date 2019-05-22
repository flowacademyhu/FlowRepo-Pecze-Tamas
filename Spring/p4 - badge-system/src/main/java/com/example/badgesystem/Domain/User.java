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
