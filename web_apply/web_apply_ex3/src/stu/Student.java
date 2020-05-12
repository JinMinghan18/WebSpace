package stu;

public class Student {
    private String stuId;
    private String name;
    private String major;
    public Student(){
    }
    public Student(String stuId,String name,String major){
        this.stuId = stuId;
        this.name = name;
        this.major = major;
    }
    public String getStuId(){
        return stuId;
    }
    public String getName(){
        return name;
    }
    public String getMajor(){
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStuId(String stuId){
        this.stuId = stuId;
    }

}
