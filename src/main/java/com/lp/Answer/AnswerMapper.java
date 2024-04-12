package com.lp.Answer;

import com.lp.Question.Question;
import com.lp.Question.QuestionDto;

public class AnswerMapper {
    public Answer toEntity(AnswerDto dto) {
        Answer object = new Answer();
        object.setAnswer(dto.getAnswer());
        object.setIsCorrect(dto.getIsCorrect());
        return object;
    }
}
