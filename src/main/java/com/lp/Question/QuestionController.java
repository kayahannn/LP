package com.lp.Question;

import com.lp.module.Module;
import com.lp.module.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new Module());
        return "question-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Question object) {
        questionRepository.save(object);
        return "redirect:/question-add";
    }

    @GetMapping("/get")
    public String getAll(Model model) {
        Iterable<Question> all = questionRepository.findAll();
        model.addAttribute("all", all);
        return "question-get";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Iterable<Question> all = questionRepository.findAll();
        model.addAttribute("all", all);
        return "question-edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        Question deleteObject = questionRepository.findById(id).orElseThrow();
        questionRepository.delete(deleteObject);
        return "module-edit";
    }
}
