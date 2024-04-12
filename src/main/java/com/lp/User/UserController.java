package com.lp.User;

import com.lp.Course.CourseRepository;
import com.lp.Question.Question;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new UserDTO());
        model.addAttribute("dropdown", courseRepository.findAll());
        return "user-add";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "user-login";
    }

    @PostMapping("/submit")
    public String submit(@Valid @ModelAttribute UserDTO objectDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/user/add";
        }
        if (objectDto.getPassword().equals(objectDto.getPassword2())) {
            userRepository.save(userMapper.toEntity(objectDto));
            return "msg-registered";
        } else {
            String errorMessage = "Passwords do not match.";
            System.out.println("Error Message: " + errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "redirect:/user/add";
        }
    }

    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<User> all = userRepository.findAll();
        model.addAttribute("all", all);
        return "user-get";
    }

}
