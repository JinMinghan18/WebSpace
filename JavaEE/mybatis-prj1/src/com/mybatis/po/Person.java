package com.mybatis.po;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
//    private Integer idcard_id;
    private Idcard card;

    public Idcard getCard() {
        return card;
    }

    public void setCard(Idcard card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public Integer getIdcard_id() {
//        return idcard_id;
//    }
//
//    public void setIdcar_id(Integer idcard_id) {
//        this.idcard_id = idcard_id;
//    }
    @Override
    public String toString() {
        return "Person [id=" + id + ",name=" + name + ",age="
                +age + ",code=" +card.getCode() +"]";
    }
}
