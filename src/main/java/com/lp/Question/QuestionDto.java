package com.lp.Question;

import com.lp.Answer.Answer;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuestionDto {
    private String name;
    private List<Answer> answerList;

    public QuestionDto() {
        this.answerList = List.of(new Answer(), new Answer(), new Answer(), new Answer());
//        this.id = id;
    }
}
