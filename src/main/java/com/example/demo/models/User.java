package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

    @Id
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String surname;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private boolean active;


    public User(Long id, String name, String surname, String username, String email, String password, boolean active){
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public User() {

    }
}
