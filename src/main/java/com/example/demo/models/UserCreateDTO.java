package com.example.demo.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDTO {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private boolean active;
}