package com.example.demo.services;
import com.example.demo.models.Topic;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    /*
     *  Testing data
     */
    private List<Topic> topicList = new ArrayList<>(Arrays.asList(
            new Topic(1L , 11L,  "Macicky", "Existuje vela maciek, biele, cierne, male aj Velke"),
            new Topic(2L , 12L, "Havinkovia", "Psy su najlepsie na svete!"),
            new Topic(3L , 13L, "Vtaciky", "Papagaj je najznamejsi a zhovorcivy!")
    ));


    public List<Topic> getAllTopics() {
        return topicList;
    }

    public Topic getTopicById(Long id) {
        return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public List<Topic> getTopicsByUserId(Long id) {
        return null;
    }

    public void addTopic(Topic topic) {

    }

    public void updateTopic(Long id, Topic topic) {
    }

    public void deleteTopic(Long id) {
    }
}
