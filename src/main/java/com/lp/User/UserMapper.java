package com.lp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private BCryptPasswordEncoder encoder;

    public User toEntity(UserDTO objectDto) {
        User user = new User();
        user.setName(objectDto.getName());
        user.setLastname(objectDto.getLastname());
        user.setPassword(encoder.encode(objectDto.getPassword()));
        user.setEmail(objectDto.getEmail());
        user.setCourse(objectDto.getCourse());

        user.setEnabled(true);
        user.setRole("User");

        return user;
    }
}
