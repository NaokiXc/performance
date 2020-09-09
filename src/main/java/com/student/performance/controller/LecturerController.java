package com.student.performance.controller;

import com.student.performance.entity.Lecturer;
import com.student.performance.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LecturerController {

    @Autowired
    private LecturerRepository lecturerRepository;

    @GetMapping("/lecturers")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Lecturer> lecturers;

        if (filter != null && !filter.isEmpty()) {
            lecturers = lecturerRepository.findSLecturersByFirstName(filter);
        } else {
            lecturers = lecturerRepository.findAll();
        }
        model.addAttribute("lecturers", lecturers);
        model.addAttribute("filter", filter);

        return "lecturers";
    }
}
