package com.example.demo.services;
import com.example.demo.models.User;
import com.example.demo.models.UserCreateDTO;
import java.util.List;

/*
 *  User service with basic methods
 */
public interface UserService {

    void addUser(UserCreateDTO user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    void updateUser(Long id, User user);
    User getUser(Long id);
}