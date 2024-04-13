package com.lp.Question;

import com.lp.Answer.Answer;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuestionDto {
    @NotBlank
    private String name;
    private List<Answer> answerList;

    public QuestionDto() {
        this.answerList = List.of(new Answer(), new Answer(), new Answer(), new Answer());
    }
}
