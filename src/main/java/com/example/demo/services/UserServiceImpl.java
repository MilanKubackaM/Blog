package com.example.demo.services;
import com.example.demo.models.User;
import com.example.demo.models.UserCreateDTO;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 *  Method application to User Repository
 */
@Service
@AllArgsConstructor
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
        userRepository.save(new User(user));
    }
    @Override
    public void updateUser(Long id, User user) {
        for (int i = 0; i < userRepository.findAll().size(); i++){
            User u = userRepository.findAllById(id);
            if(u.getId().equals(id)){
                userRepository.save(user);
                return;
            }
        }
    }

/*
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
}