package com.student.performance.controller;

import com.student.performance.entity.Student;
import com.student.performance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/students")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Student> students = studentRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            students = studentRepository.findStudentsByFirstName(filter);
        } else {
            students = studentRepository.findAll();
        }
        model.addAttribute("students", students);
        model.addAttribute("filter", filter);

        return "students";
    }
}
