package com.lp.Answer;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnswerDto {
    private String answer;
    private Boolean isCorrect;
}
