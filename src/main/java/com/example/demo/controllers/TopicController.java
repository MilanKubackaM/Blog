package com.example.demo.controllers;
import com.example.demo.models.Topic;
import com.example.demo.services.TopicServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TopicController
{

    @Autowired
    private TopicServiceImpl topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/user/{id}")
    public List<Topic> getTopicsByUserId(@PathVariable Long id){
        return topicService.getTopicsByUserId(id);
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable Long id){
        return topicService.getTopicById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public ResponseEntity<Topic> addTopic(@Valid @RequestBody Topic topic){
        topicService.addTopic(topic);
        return new ResponseEntity<Topic>(topic, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
    }
}
