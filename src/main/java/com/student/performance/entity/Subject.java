package com.student.performance.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;

    @ElementCollection(targetClass = Group.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "group_subject", joinColumns = @JoinColumn(name = "subject_id"))
    @Enumerated(EnumType.STRING)
    private Set<Group> groups = new HashSet<>();

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


}
