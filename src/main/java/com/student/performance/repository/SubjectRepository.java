package com.student.performance.repository;

import com.student.performance.entity.Group;
import com.student.performance.entity.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    List<Subject> findSubjectsByGroups(Group group);
}
