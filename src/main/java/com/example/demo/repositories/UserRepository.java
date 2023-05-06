package com.example.demo.repositories;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllById(Long id);
    List<User> findAllByUsernameAndPassword(String username, String password);
}