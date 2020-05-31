package com.dao;

import com.model.Student;
import com.model.Teacher;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HealthCodeDao extends Base2Dao {
    //查询所有学生信息
    public ArrayList<Student> findAllStudent() {
        ArrayList<Student> stuList = new ArrayList<Student>();
        String sql = "SELECT * FROM students";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Student student = new Student();
                    student.setName(rst.getString("name"));
                    student.setId(rst.getString("id"));
                    student.setSchool_id(rst.getString("school_id"));
                    student.setCollege(rst.getString("college"));
                    student.setMajor(rst.getString("major"));
                    student.setClass1(rst.getString("class1"));
                    stuList.add(student);
                }
            }
            return stuList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }


    //查询所有教师信息
    public ArrayList<Teacher> findAllTeacher() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        String sql = "SELECT * FROM teachers";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setName(rst.getString("name"));
                    teacher.setId(rst.getString("id"));
                    teacher.setSchool_id(rst.getString("school_id"));
                    teacher.setCollege(rst.getString("college"));
                    teacher.setRole(rst.getString("role"));
                    teacherList.add(teacher);
                }
            }
            return teacherList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }


    //添加学生
    public boolean addStudent(Student student){
        String sql = "INSERT INTO students" + "(name,id,school_id,college,major,class1)VALUES(?,?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getId());
            pstmt.setString(3,student.getSchool_id());
            pstmt.setString(4,student.getCollege());
            pstmt.setString(5,student.getMajor());
            pstmt.setString(6,student.getClass1());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    //添加教师
    public boolean addTeacher(Teacher teacher){
        String sql = "INSERT INTO teachers" + "(name,id,school_id,college,role)VALUES(?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getId());
            pstmt.setString(3,teacher.getSchool_id());
            pstmt.setString(4,teacher.getCollege());
            pstmt.setString(5,teacher.getRole());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }


    //修改学生信息
    public boolean modifyStudent(Student student){
        String sql = "UPDATE students SET id=?,school_id=?,college=?,major=?,class1=? WHERE name=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,student.getId());
            pstmt.setString(2,student.getSchool_id());
            pstmt.setString(3,student.getCollege());
            pstmt.setString(4,student.getMajor());
            pstmt.setString(5,student.getClass1());
            pstmt.setString(6,student.getName());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    //修改学生信息
    public boolean modifyTeacher(Teacher teacher){
        String sql = "UPDATE teachers SET id=?,school_id=?,college=?,role=? WHERE name=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,teacher.getId());
            pstmt.setString(2,teacher.getSchool_id());
            pstmt.setString(3,teacher.getCollege());
            pstmt.setString(4,teacher.getRole());
            pstmt.setString(5,teacher.getName());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    //删除学生信息
    public boolean deleteStudent(String name){
        String sql = "DELETE FROM students WHERE name=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            if(pstmt.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return false;
    }


    //删除教师信息
    public boolean deleteTeacher(String name){
        String sql = "DELETE FROM teachers WHERE name=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            if(pstmt.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return false;
    }


    //查询学生
    public ArrayList<Student> findStudent(String college,String major,String class1){
       String sql = "SELECT * FROM students WHERE college=? AND major=? AND class1=?";
       ArrayList<Student> stuList = new ArrayList<Student>();
       try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){

           pstmt.setString(1,college);
           pstmt.setString(2,major);
           pstmt.setString(3,class1);
           try(ResultSet rst = pstmt.executeQuery()){
               while(rst.next()){
                   Student student = new Student();
                   student.setName(rst.getString("name"));
                   System.out.println(rst.getString("name"));
                   student.setId(rst.getString("id"));
                   System.out.println(rst.getString("id"));
                   student.setSchool_id(rst.getString("school_id"));
                   System.out.println(rst.getString("school_id"));
                   student.setCollege(rst.getString("college"));
                   System.out.println(rst.getString("college"));
                   student.setMajor(rst.getString("major"));
                   System.out.println(rst.getString("major"));
                   student.setClass1(rst.getString("class1"));
                   System.out.println(rst.getString("class1"));
                   stuList.add(student);
               }
           }
           return stuList;
       }catch (SQLException se){
           se.printStackTrace();
           return null;
       }
    }

    //查询老师
    public ArrayList<Teacher> findTeacher(String college){
        String sql = "SELECT * FROM teachers WHERE college=?";
        ArrayList<Teacher> teaList = new ArrayList<Teacher>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,college);

            try(ResultSet rst = pstmt.executeQuery()){
                while(rst.next()){
                    Teacher teacher = new Teacher();
                    teacher.setName(rst.getString("name"));

                    teacher.setId(rst.getString("id"));

                    teacher.setSchool_id(rst.getString("school_id"));

                    teacher.setCollege(rst.getString("college"));

                    teacher.setRole(rst.getString("role"));
                    teaList.add(teacher);
                }
            }
            return teaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //批量导入学生
    public boolean addMoreStudent(String str){
        String sql="INSERT INTO students" + "(name,id,school_id,college,major,class1)VALUES(?,?,?,?,?,?)";
        int count = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==';'){
                count++;
            }
        }
        System.out.println(count);
        String[] list =  str.split(";");
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))   {
            for(int i = 0;i < count;i++){

                String[] result = list[i].split(",");
                pstmt.setString(1,result[0]);
                pstmt.setString(2,result[1]);
                pstmt.setString(3,result[2]);
                pstmt.setString(4,result[3]);
                pstmt.setString(5,result[4]);
                pstmt.setString(6,result[5]);
                System.out.println(result[1]);
                pstmt.executeUpdate();
            }
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }


    }


    //批量导入教师
    public boolean addMoreTeacher(String str){
        String sql = "INSERT INTO teachers" + "(name,id,school_id,college,role)VALUES(?,?,?,?,?)";
        int count = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==';'){
                count++;
            }
        }
        System.out.println(count);
        String[] list =  str.split(";");
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql))   {
            for(int i = 0;i < count;i++){

                String[] result = list[i].split(",");
                pstmt.setString(1,result[0]);
                pstmt.setString(2,result[1]);
                pstmt.setString(3,result[2]);
                pstmt.setString(4,result[3]);
                pstmt.setString(5,result[4]);
                System.out.println(result[1]);
                pstmt.executeUpdate();
            }
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }


    }
}
