package com.model;

public class Student {
    private String name;
    private String id;
    private String school_id;
    private String college;
    private String major;
    private String class1;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getClass1() {
        return class1;
    }

    public String getCollege() {
        return college;
    }

    public String getMajor() {
        return major;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }
}
