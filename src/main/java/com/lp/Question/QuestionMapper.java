package com.lp.Question;

import org.springframework.stereotype.Component;
@Component
public class QuestionMapper {

        public  Question toEntity(QuestionDto dto) {
            Question object = new Question();
            object.setName(dto.getName());
            object.setAnswerList(dto.getAnswerList());
            return object;
        }
}
