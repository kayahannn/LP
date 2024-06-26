package com.lp.Question;

import com.lp.Answer.Answer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Answer> answerList;


    public Question() {
        this.answerList = List.of(new Answer(), new Answer(), new Answer(), new Answer());
    }
}
