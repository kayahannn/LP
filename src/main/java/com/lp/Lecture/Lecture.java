package com.lp.Lecture;

import com.lp.module.Module;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;
    @NotBlank
    private String lnk_video;
    @NotBlank
    private String lnk_doc;
    @ManyToOne
    private Module module;

}
