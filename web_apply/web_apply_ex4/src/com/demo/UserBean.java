package com.demo;

public class UserBean {
    private String type;
    private String id;
    private String password;
    private String name;

    public UserBean(){}
    public UserBean(String id,String password,String name,String type){
        this.id=id;
        this.password=password;
        this.name=name;
        this.type=type;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
}
