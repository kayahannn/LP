package com.lp.User;

import com.lp.Course.CourseRepository;
import com.lp.Question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;
//    @Autowired
//    BCryptPasswordEncoder encoder;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new UserDTO());
        model.addAttribute("dropdown", courseRepository.findAll());
        return "user-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute UserDTO object) {
        userRepository.save(userMapper.toEntity(object));
        return "redirect:/login";
    }
    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<User> all = userRepository.findAll();
        model.addAttribute("all", all);
        return "user-get";
    }

}
