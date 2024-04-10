package com.lp.User;

import com.lp.Course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private Course course;

}
