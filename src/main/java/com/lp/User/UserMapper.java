//package com.lp.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserMapper {
//    @Autowired
//    private BCryptPasswordEncoder encoder;
//
//    public User toEntity(UserDTO object) {
//        User user = new User();
//        user.setUsername(object.getUsername());
//        user.setPassword(encoder.encode(object.getPassword()));
//        user.setEmail(object.getEmail());
//
//        user.setEnabled(true);
//        user.setRole("User");
//
//        return user;
//    }
//}
