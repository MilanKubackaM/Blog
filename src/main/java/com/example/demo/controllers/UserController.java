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

/**
 *   REST API mapping for handling requests of Users
 *         METHOD                                LINK                                   RETURN
 *   -> GET all users:                  http://localhost:8080/users             ->  List<User>
 *   -> GET user by ID:                 http://localhost:8080/users/{id}        ->  User
 *   -> GET id of user by post username:http://localhost:8080/users/{username}  ->  ResponseEntity<Long> (id)
 *   -> POST user to create new user:   http://localhost:8080/users             ->  ResponseEntity<Strong>
 *   -> POST user to login:             http://localhost:8080/users/login       ->  ResponseEntity<String>
 *   -> PUT find user and update it:    http://localhost:8080/users/{id}        ->  void
 *   -> DELETE set up user inactive:    http://localhost:8080/users/{id}        ->  void
 */

@ControllerAdvice
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

/**
 *  Find user bys username and return ID
 *  for keeping data of logged user
 */

    @PostMapping("/{username}")
    public ResponseEntity<Long> findUser(@PathVariable String username) {
        Long id = userService.findUserIdByUsername(username);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@Valid @RequestBody UserCreateDTO user) {
        userService.addUser(user);
        return new ResponseEntity<>("Registration success", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserCreateDTO user) {
        boolean success = userService.checkUser(user.getUsername(), user.getPassword());
        System.out.println("nick:" + user.getSurname() + " heslo:" + user.getPassword());
        if (success) {
            return new ResponseEntity<>("Login success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Login Error", HttpStatus.BAD_REQUEST);
    }

    /**
     *  Find user by ID and update it
     */
    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserCreateDTO user, @PathVariable Long id) {
        System.out.println("id:" + id);
        userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}