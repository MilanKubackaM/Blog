package com.example.demo.controllers;
import com.example.demo.models.Topic;
import com.example.demo.models.TopicCreateDTO;
import com.example.demo.services.TopicServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
 *   REST API mapping for handling requests of Topics
 */

@RestController
@RequestMapping("/topics")
public class TopicController
{

    @Autowired
    private TopicServiceImpl topicService;

    @GetMapping
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

/*
 *   TODO: Not working yet, needs to be done
 */
    @GetMapping("/user/{id}")
    public List<Topic> getTopicsByUserId(@PathVariable Long id){
        return topicService.getTopicsByUserId(id);
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Long id){
        return topicService.getTopicById(id);
    }

    @PostMapping
    public ResponseEntity<TopicCreateDTO> addTopic(@Valid @RequestBody TopicCreateDTO topic){
        topicService.addTopic(topic);
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
    }
}