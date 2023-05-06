package com.example.demo.repositories;
import com.example.demo.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {
    Topic findAllById(Long id);
}
