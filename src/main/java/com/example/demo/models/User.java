package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, message = "Name should be at least 2 characters")
    private String name;
    @NotNull
    @Size(min = 2, message = "Surname should be at least 2 characters")
    @NotNull
    private String surname;
    @Column(unique = true)
    @Size(min = 5, message = "Username should be at least 5 characters")
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 6, message = "Password should be at least 6 characters")
    private String password;
    private boolean active;

/*
 *  Using DTO for data encapsulation
 */
    public User(UserCreateDTO user){
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
    }
}