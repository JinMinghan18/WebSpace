package com.model;

import java.util.function.IntSupplier;

public class Course {
    private String cno;
    private String cname;
    private String cterm;
    private int ctime;
    private String cway;
    private String ccredit;

    public Course() {
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCterm() {
        return cterm;
    }

    public void setCterm(String cterm) {
        this.cterm = cterm;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public String getCway() {
        return cway;
    }

    public void setCway(String cway) {
        this.cway = cway;
    }

    public String getCcredit() {
        return ccredit;
    }

    public void setCcredit(String ccredit) {
        this.ccredit = ccredit;
    }
}
