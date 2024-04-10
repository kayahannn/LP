package com.lp.module;

import com.lp.Course.CourseRepository;
import com.lp.Lecture.Lecture;
import com.lp.Lecture.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("module")
public class ModuleController {
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new Module());
        model.addAttribute("dropdown", courseRepository.findAll());
        model.addAttribute("all", moduleRepository.findAll());
        return "module-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Module object) {
        moduleRepository.save(object);
        return "redirect:/module/add";
    }

    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<Module> all = moduleRepository.findAll();
        model.addAttribute("all", all);
        return "module-get";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Iterable<Module> all = moduleRepository.findAll();
        model.addAttribute("all", all);
        return "module-edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Module deleteObject = moduleRepository.findById(id).orElseThrow();
        moduleRepository.delete(deleteObject);
        return "module-edit";
    }
}

