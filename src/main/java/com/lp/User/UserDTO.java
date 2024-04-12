package com.lp.User;

import com.lp.Course.Course;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String name;
    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String lastname;
    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password2;
    @NotBlank
    private Course course;

}
