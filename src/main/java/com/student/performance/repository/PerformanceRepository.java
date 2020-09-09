package com.student.performance.repository;

import com.student.performance.entity.Performance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerformanceRepository extends CrudRepository<Performance, Object> {

    List<Performance> findByStudent_SurName(String surName);

    @Query(nativeQuery = true, value = "SELECT student_id, AVG(value) as valueAvg" +
            " FROM performance GROUP BY student_id ORDER BY AVG(value) DESC LIMIT 3")
    List<Object[]> findByAvgDesc();

    @Query(nativeQuery = true, value = "SELECT student_id, AVG(value) as valueAvg" +
            " FROM performance GROUP BY student_id ORDER BY AVG(value) ASC LIMIT 3")
    List<Object[]> findByAvgAsc();

}
