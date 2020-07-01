package com.model;

public class HealthCode {
    private String name;
    private String id;
    private String stuid;
    private String tel;
    private int choice;

    public HealthCode(){}
    public HealthCode(String name, String id, String stuid, String tel, int choice){
        this.id = id;
        this.name = name;
        this.stuid = stuid;
        this.tel = tel;
        this.choice = choice;
    }

    public int getChoice(){
        return choice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStuid() {
        return stuid;
    }

    public String getTel() {
        return tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
