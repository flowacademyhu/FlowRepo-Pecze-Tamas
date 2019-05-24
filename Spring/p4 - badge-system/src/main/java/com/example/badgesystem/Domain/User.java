package com.example.badgesystem.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    public User() {
    }
    @Column
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(mappedBy = "user_badges")
    Set<Badge> badges;

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
    private Badge badge;

    public User(int id, Set<Badge> badges, String username, String fullname, String password, String role, Badge badge) {
        this.id = id;
        this.badges = badges;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
        this.badge = badge;
    }

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }

    public User(String username, String fullname, String password, String role) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
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
