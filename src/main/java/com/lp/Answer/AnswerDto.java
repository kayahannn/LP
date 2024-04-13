package com.lp.Answer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnswerDto {
    @NotBlank
    private String answer;
    private Boolean isCorrect = false;
}
