package com.example.demo.services;
import com.example.demo.models.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl {

    //Testing data
    private List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Peter", "Makovicky", "fesak123", "nieco@gmail.com", "heslo123", true),
            new User("Milan", "Kuabcka", "znasisa112", "iny@gmail.com", "heslo1334", true),
            new User("Andrea", "Nejaka", "kralovna99", "nejaky@gmail.com", "heslo12343", true)
    ));

    public List<User> getAllUsers(){
        return userList;
    }

    public User getUser(Long id) {
        return userList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addUser(User user) {
        user.setActive(true);
        userList.add(user);
    }

    public void updateUser(Long id, User user) {
        for (int i = 0; i < userList.size(); i++){
            User u = userList.get(i);
            if(u.getId().equals(id)){
                userList.set(i, user);
                return;
            }
        }
    }

    //Delete will just mark up active = false (record will not be deleted from database)
    public void deleteUser(Long id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                user.setActive(false);
                break;
            }
        }
    }
}
