package com.lp.Answer;

import com.lp.Question.Question;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    //    @Column(columnDefinition = "tinyint(1) default 1")
    @Column(name = "is_correct", columnDefinition = "boolean default false")
    private Boolean correct;

    public boolean getIsCorrect() {
        return correct;
    }

    public void setIsCorrect(boolean isCorrect) {
        correct = isCorrect;
    }
}
