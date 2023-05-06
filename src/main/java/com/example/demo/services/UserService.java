package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {

    // Save a record of user
    <S extends User> void save(S entity);

    // Fin all users
    List<User> findAll();
}