package com.student.performance.entity;

import javax.persistence.*;

@Entity
@Table(name = "s_group")
public class Group{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;
    private String groupName;
    private String speciality;

    public Group() {
    }

    public Group(Long groupId) {
        this.groupId = groupId;
    }

    public Group(Long groupId, String groupName, String speciality) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.speciality = speciality;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}