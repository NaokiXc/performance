package com.student.performance.repository;

import com.student.performance.entity.Lecturer;
import com.student.performance.entity.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    List<Lecturer> findSLecturersByFirstName(String firstName);
    List<Lecturer> findLecturersBySubjects(Subject subject);

}