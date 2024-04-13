package com.lp.Homework;

import com.lp.Lecture.Lecture;
import com.lp.Question.Question;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "homeworks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean passed;
    @ManyToMany
    private List<Question> questionList;
    @OneToOne
    private Lecture lecture;

}
