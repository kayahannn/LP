package com.lp.Course;

import com.lp.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
