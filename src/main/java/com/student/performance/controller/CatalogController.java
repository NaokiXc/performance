package com.student.performance.controller;

import com.student.performance.entity.*;
import com.student.performance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/catalog")
    public String main(Model model) {
        Iterable<Group> groups;
        Iterable<Subject> subjects;

        groups = groupRepository.findAll();
        subjects = subjectRepository.findAll();

        model.addAttribute("groups", groups);
        model.addAttribute("subjects", subjects);

        return "catalog";
    }
}
