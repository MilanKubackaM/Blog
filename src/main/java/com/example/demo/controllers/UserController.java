package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.models.UserCreateDTO;
import com.example.demo.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 *   REST API mapping for handling requests of Users
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<UserCreateDTO> addUser(@Valid @RequestBody UserCreateDTO user){
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping(value="/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(id, user);
    }

    @DeleteMapping(value="/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}