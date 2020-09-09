package com.student.performance.controller;

import com.student.performance.entity.*;
import com.student.performance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String performanceList(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Performance> performances;

        if (filter != null && !filter.isEmpty()) {
            performances = performanceRepository.findByStudent_SurName(filter);
        } else {
            performances = performanceRepository.findAll();
        }

        model.addAttribute("performances", performances);
        model.addAttribute("filter", filter);

        return "performance";
    }

    @GetMapping("add")
    public String addMain(Model model) {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        Iterable<Lecturer> lecturers  = lecturerRepository.findAll();
        model.addAttribute("lecturers", lecturers);

        return "performance-add";
    }

    @GetMapping("add/{student}")
    public String addWithStudent(@PathVariable Student student, Model model) {
        Iterable<Subject> subjects = subjectRepository.findSubjectsByGroups(student.getGroup());
        model.addAttribute("subjects", subjects);
        model.addAttribute("student", student);
        return "performance-add-student";
    }

    @GetMapping("add/{student}/{subject}")
    public String addWithSubject(@PathVariable Student student,
                                           @PathVariable Subject subject, Model model) {
        Iterable<Lecturer> lecturers = lecturerRepository.findLecturersBySubjects(subject);

        model.addAttribute("subject", subject);
        model.addAttribute("student", student);
        model.addAttribute("lecturers",lecturers);

        return "performance-add-student-subject";
    }

    //TODO Сделай вью и доделай контроллер
    @GetMapping("add/{student}/{subject}/{lecturer}")
    public String addWithLecturer(@PathVariable Student student,
                                 @PathVariable Subject subject, @PathVariable Lecturer lecturer, Model model) {
        model.addAttribute("subject", subject);
        model.addAttribute("student", student);
        model.addAttribute("lecturer",lecturer);

        return "performance-add-value";
    }

    @GetMapping("rating")
    public String rating( Model model) {
        Long[] studentsIdAsc = new Long[3];
        Long[] studentsIdDesc = new Long[3];

        String[] studentsValueAsc = new String[3];
        String[] studentsValueDesc = new String[3];

        List<Object[]> listOfResultAsc = performanceRepository.findByAvgAsc();
        List<Object[]> listOfResultDesc = performanceRepository.findByAvgDesc();

        LinkedHashMap<Student, String> StudentAsc = new LinkedHashMap<Student, String>();
        LinkedHashMap<Student, String> StudentDesc = new LinkedHashMap<Student, String>();

        int counter = 0;

        for (Object[] object: listOfResultAsc) {
            studentsIdAsc[counter] = Long.parseLong(object[0].toString());
            studentsValueAsc[counter] = object[1].toString();
            counter++;
        }

        counter = 0;

        for (Object[] object: listOfResultDesc) {
            studentsIdDesc[counter] = Long.parseLong(object[0].toString());
            studentsValueDesc[counter] = object[1].toString();
            counter++;
        }

        counter = 0;
        for (Long id : studentsIdAsc){
            if(id == null){
                counter ++;
                continue;
            }
            StudentAsc.put(studentRepository.findStudentByStudentId(id),studentsValueAsc[counter]);
            counter ++;
        }

        counter = 0;
        for (Long id : studentsIdDesc){
            if(id == null){
                counter ++;
                continue;
            }
            StudentDesc.put(studentRepository.findStudentByStudentId(id),studentsValueDesc[counter]);
            counter ++;
        }

        model.addAttribute("studentsAsc", StudentAsc);
        model.addAttribute("studentsDesc", StudentDesc);

        return "rating";
    }

    @PostMapping
    public String addPerformance(
            @RequestParam("studentId") Student student,
            @RequestParam("subjectId") Subject subject, @RequestParam("lecturerId") Lecturer lecturer,
            @RequestParam String value
    ) {
        Performance performance = new Performance(student, subject, lecturer, Integer.parseInt(value));
        performanceRepository.save(performance);
        return "redirect:/performance";
    }
}
