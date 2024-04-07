package com.lp.Lecture;

import com.lp.Homework.Homework;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lectures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String video_lnk;
    private String presentation_lnk;
    @ManyToOne
    private Homework homework;

}
