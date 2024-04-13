package com.lp.Lecture;

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
    @GetMapping("/get/{id}")
    public String getById(@PathVariable Long id, @ModelAttribute("lecture") Lecture lecture, Model model) {
        lecture = lectureRepository.getById(id);
        model.addAttribute("video", lecture.getLnk_video());
        model.addAttribute("doc", lecture.getLnk_doc());
        return "lecture-page";
    }
    @GetMapping("/getAll/{id}")
    public String getLectureByUserId(@PathVariable Long id) {
       Iterable<Lecture> lectureList = lectureRepository.findByUserId(id);
        return "lecture-get";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Lecture deleteObject = lectureRepository.findById(id).orElseThrow();
        lectureRepository.delete(deleteObject);
        return "lecture-edit";
    }
}
