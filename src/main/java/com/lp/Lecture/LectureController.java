package com.lp.Lecture;

import com.lp.Course.Course;
import com.lp.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("lecture")
public class LectureController {
    @Autowired
    LectureRepository lectureRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new Lecture());
        return "lecture-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Lecture object) {
        lectureRepository.save(object);
        return "redirect:/lecture-add";
    }

    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<Lecture> all = lectureRepository.findAll();
        model.addAttribute("all", all);
        return "lecture-get";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Iterable<Lecture> all = lectureRepository.findAll();
        model.addAttribute("all", all);
        return "lecture-edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Lecture deleteObject = lectureRepository.findById(id).orElseThrow();
        lectureRepository.delete(deleteObject);
        return "lecture-edit";
    }
}
