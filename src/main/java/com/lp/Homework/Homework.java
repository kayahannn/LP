package com.lp.Homework;

import com.lp.Course.Course;
import com.lp.Lecture.Lecture;
import com.lp.Question.Question;
import com.lp.User.User;
import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    private Question question;

}
