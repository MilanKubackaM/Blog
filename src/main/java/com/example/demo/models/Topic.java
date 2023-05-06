package com.example.demo.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Table(name = "topics")
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @NotEmpty
    private Long userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String text;

    public Topic(){}

    public Topic(Long id, Long userId, String name, String text) {
    /*
     *  Assign ID and userID for testing,
     *  delete after connecting to database
    */
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.text = text;
    }
}
