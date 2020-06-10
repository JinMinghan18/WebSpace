package com.model;

public class Teacher {
    private String name;
    private String id;
    private String school_id;
    private String college;//学院
    private String role;//系统管理员、校级管理员、院级管理员、普通教师
    private String attendenceRecord;//打卡天数

    public String getAttendenceRecord() {
        return attendenceRecord;
    }

    public String getSchool_id() {
        return school_id;
    }

    public String getCollege() {
        return college;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setAttendenceRecord(String attendenceRecord) {
        this.attendenceRecord = attendenceRecord;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}