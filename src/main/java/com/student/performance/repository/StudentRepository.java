package com.student.performance.repository;

import com.student.performance.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentsByFirstName(String firstName);
    List<Student> findStudentsBySurName (String surName);
    Student findStudentByStudentId (Long studentId);

}