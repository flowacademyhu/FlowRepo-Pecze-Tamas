package com.example.badgesystem.Domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "badges")
public class Badge {
    public Badge() {
    }

    @Id
    @GeneratedValue
    @Column
    private int id;

    public Badge(int id, Set<User> user_badges, String name, String content, String owner, List<User> users) {
        this.id = id;
        this.user_badges = user_badges;
        this.name = name;
        this.content = content;
        this.owner = owner;
        this.users = users;
    }

    public Set<User> getUser_badges() {
        return user_badges;
    }

    public void setUser_badges(Set<User> user_badges) {
        this.user_badges = user_badges;
    }

    @ManyToMany
            @JoinTable(
                    name = "user_badges",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "badge_id")
            )
    Set<User> user_badges;

    @Column
    private String name;

    @Column
    private String content;

    @Column
    private String owner;

    @OneToMany(mappedBy = "badge")
    private List<User> users;

    public Badge(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Badge(String name, String content, String owner) {
        this.name = name;
        this.content = content;
        this.owner = owner;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
