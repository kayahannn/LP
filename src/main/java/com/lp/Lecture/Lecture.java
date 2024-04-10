package com.lp.Lecture;

import com.lp.Homework.Homework;
import com.lp.module.Module;
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
    private String lnk_video;
    private String lnk_pdf;
    @ManyToOne
    private Module module;

}
