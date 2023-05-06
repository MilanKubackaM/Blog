package com.example.demo.services;
import com.example.demo.models.Topic;
import com.example.demo.models.TopicCreateDTO;
import com.example.demo.repositories.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 *  Method application to Topic Repository
 */

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService{

    @Autowired
    private final TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
    @Override
    public Topic getTopicById(Long id) {
        return topicRepository.findAllById(id);
    }
    @Override
    public List<Topic> getTopicsByUserId(Long id) {
        return null;
    }

    @Override
    public void addTopic(TopicCreateDTO topic) {
        topicRepository.save(new Topic(topic));
    }
    @Override
    public void updateTopic(Long id, Topic topic) {
    }
    @Override
    public void deleteTopic(Long id) {
    }
}