package com.lp.User;

import com.lp.Course.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String name;
    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String lastname;
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    @ManyToOne
    private Course course;

}
