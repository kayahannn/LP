package com.lp.Question;

import com.lp.Answer.Answer;
import com.lp.Answer.AnswerRepository;
import com.lp.module.Module;
import com.lp.module.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionMapper questionMapper;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newC", new QuestionDto());
        return "question-add";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionDto object) {
        for (Answer answer : object.getAnswerList()) {
            answerRepository.save(answer);
        }

//        Iterable<Answer> iterAnswer = object.getAnswerList();
//        List<Answer> storedAnswers = (List<Answer>) answerRepository.saveAll(iterAnswer);
        Question question = questionMapper.toEntity(object);
        question.setAnswerList(object.getAnswerList());

//        question.setAnswerList(storedAnswers);
        questionRepository.save(question);

        return "redirect:/question/add";
    }

    @PostMapping("/submit_answer")
    public String submitAnswer(@ModelAttribute Answer answer) {
        answerRepository.save(answer);
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
