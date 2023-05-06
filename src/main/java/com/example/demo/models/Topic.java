package com.example.demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topics")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

/*
 *  Topic class with defined column in database table
 */

public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    private Long userId;
    private String name;
    private String text;

/*
 *  Using DTO for data encapsulation
 */
    public Topic(TopicCreateDTO topic) {
        this.userId = topic.getUserId();
        this.name = topic.getName();
        this.text = topic.getText();
    }
}
