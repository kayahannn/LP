package com.lp.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new Course());
        return "course-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Course object) {
        courseRepository.save(object);
        return "redirect:/course-add";
    }

    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<Course> all = courseRepository.findAll();
        model.addAttribute("all", all);
        return "course-get";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Iterable<Course> all = courseRepository.findAll();
        model.addAttribute("all", all);
        return "course-edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Course deleteObject = courseRepository.findById(id).orElseThrow();
        courseRepository.delete(deleteObject);
        return "course-edit";
    }
}
