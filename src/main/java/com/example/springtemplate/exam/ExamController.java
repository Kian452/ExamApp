package com.example.springtemplate.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {
    private final ExamRepository examRepository;

    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @PostMapping(path = "/newexam")
    public Exam createExam(@RequestBody ExamRequest request) {
        Exam exam = new Exam();
        exam.setName(request.getName());
        return examRepository.save(exam);
    }

    @GetMapping("/all")
    public List<Exam> allExams() {
        return examRepository.findAll();
    }
}
