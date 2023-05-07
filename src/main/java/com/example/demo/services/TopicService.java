package com.example.demo.services;
import com.example.demo.models.Topic;
import com.example.demo.models.TopicCreateDTO;
import java.util.List;

/**
 *  Topic service with basic methods
 */

public interface TopicService{
    List<Topic> getAllTopics();

    Topic getTopicById(Long id);

    List<Topic> getTopicsByUserId(Long id);

    void addTopic(TopicCreateDTO topic);

    void updateTopic(Long id, Topic topic);

    void deleteTopic(Long id);
}