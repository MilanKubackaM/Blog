package com.example.demo.services;
import com.example.demo.models.User;
import com.example.demo.models.UserCreateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *  User service with basic methods
 */
public interface UserService {

    void addUser(UserCreateDTO user);
    List<User> getAllUsers();

    ResponseEntity<User> updateUser(UserCreateDTO userCreateDTO, Long id);

    void deleteUser(Long id);
    User getUser(Long id);
    boolean checkUser(String username, String password);
}