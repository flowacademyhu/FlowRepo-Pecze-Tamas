package com.example.badgesystem.Domain;

import javax.persistence.*;

@Entity
@Table(name = "badges")
public class Badge {
    public Badge() {
    }

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String content;

    @Column
    private String owner;

    public Badge(String name, String content, String owner) {
        this.name = name;
        this.content = content;
        this.owner = owner;
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
