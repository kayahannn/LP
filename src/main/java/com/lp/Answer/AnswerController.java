package com.lp.Answer;

import com.lp.Course.Course;
import com.lp.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("answer")
public class AnswerController {
    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new Answer());
        return "answer-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Answer object) {
        answerRepository.save(object);
        return "redirect:/answer-add";
    }

    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<Answer> all = answerRepository.findAll();
        model.addAttribute("all", all);
        return "answer-get";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Iterable<Answer> all = answerRepository.findAll();
        model.addAttribute("all", all);
        return "answer-edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Answer deleteObject = answerRepository.findById(id).orElseThrow();
        answerRepository.delete(deleteObject);
        return "course-edit";
    }
}
