package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@AllArgsConstructor
public class User {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    //@Size(min = 2, message = "Name should be at least 2 characters")
    @Getter
    @Setter
    private String name;
    @NotEmpty
    //@Size(min = 2, message = "Surname should be at least 2 characters")
    @Getter
    @Setter
    private String surname;
    @Column(unique = true)
    @NotEmpty
    @Size(min = 5, message = "Username should be at least 5 characters")
    @Getter
    @Setter
    private String username;
    @NotEmpty
    //@Email
    @Getter
    @Setter
    private String email;
    @NotEmpty
    //@Size(min = 6, message = "Password should be at least 6 characters")
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private boolean active;


    public User(String name, String surname, String username, String email, String password, boolean active){
        super();
        //this.id = id;
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
