package com.example.demo.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *  Topic class with defined column in database table
 */
@Table(name = "topics")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

/**
 *  Using DTO for data encapsulation
 */
    public Topic(TopicCreateDTO topic) {
        this.user = topic.getUser();
        this.name = topic.getName();
        this.text = topic.getText();
    }
}
