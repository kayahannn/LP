package com.lp.Lecture;

import com.lp.Course.Course;
import com.lp.Course.CourseRepository;
import com.lp.module.Module;
import com.lp.module.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("lecture")
public class LectureController {
    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    ModuleRepository moduleRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new Lecture());

        model.addAttribute("dropdown", moduleRepository.findAll());
        return "lecture-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Lecture object) {
        lectureRepository.save(object);
        return "redirect:/lecture/add";
    }

    @GetMapping("/get")
    public String getAll(Model model, Lecture object) {
        Iterable<Lecture> all = lectureRepository.findAll();
        model.addAttribute("all", all);
        Lecture lecture = new Lecture();
        lecture.setLnk_video("https://www.youtube.com/embed/tgbNymZ7vqY");
        lecture.setLnk_pdf("https://docs.google.com/document/d/1n4nMNtc7qKfW64z8kSq-ibtNIhgnDtNrXMhivENYT78/edit");
        model.addAttribute("video",lecture.getLnk_video());
        model.addAttribute("doc", lecture.getLnk_pdf());
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
