package com.example.demo.services;
import com.example.demo.models.User;
import com.example.demo.models.UserCreateDTO;
import com.example.demo.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.List;

/**
 *  Method application to User Repository
 */
@Service
@AllArgsConstructor
@ControllerAdvice
@Getter
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User getUser(Long id) {
        return userRepository.findAllById(id);
    }
    @Override
    public void addUser(UserCreateDTO user) {
        user.setActive(true);
        User newUser;
        try {
            newUser = new User(user);
        } catch (Exception e) {
            System.out.println("Error occurred in 'UserServiceImpl->addUser()': " + e.getMessage());
            return;
        }
        userRepository.save(newUser);
    }

/**
 *  Replace existing user with updated (update happens on FE),
 *  this method just copy properties except ID
 *  TODO: Handle exceptions correctly
 */
    @Override
    public ResponseEntity<User> updateUser(UserCreateDTO updateUser, Long id) {
        User existingUser;
        try {
            existingUser = userRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
        } catch (Exception e) {
            System.out.println("Invalid properties provided in 'UserServiceImpl->updateuser()'");
            return ResponseEntity.badRequest().build();
        }
        BeanUtils.copyProperties(updateUser, existingUser, "id");
        User updatedUser = userRepository.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }

/**
 *  Delete will just mark up active = false (record will not be deleted from database)
 */
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findAllById(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public boolean checkUser(String username, String password){
        List<User> users = userRepository.findAllByUsernameAndPassword(username, password);
        if(users.isEmpty()){
            return false;
        }
        return true;
    }

    public Long findUserIdByUsername(String username) {
        User user = userRepository.findAllByUsername(username);
        return user.getId();
    }
}