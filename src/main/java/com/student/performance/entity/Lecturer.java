package com.student.performance.entity;

import javax.persistence.*;
import java.util.*;
import javax.persistence.Id;

@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturerId;
    private String firstName;
    private String surName;
    private String patronymic;
    private Date dateOfBirth;
    private char sex;

    @ElementCollection(targetClass = Subject.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "lecture_subject", joinColumns = @JoinColumn(name = "lecture_id"))
    @Enumerated(EnumType.STRING)
    private Set<Subject> subjects = new HashSet<>();

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public String getSubjectsString(){
        String subjectString = "";
        for (Subject elem : subjects) {
            subjectString += elem.getSubjectName() + ", ";
        }
        subjectString = subjectString.substring(0,subjectString.length() - 2);

        return subjectString;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getFullName(){
        return firstName + " " + surName + " " + patronymic;
    }

}
