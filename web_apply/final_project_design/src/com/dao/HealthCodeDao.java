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

public class HealthCodeDao extends Basedao{
    //查找学生信息
    public Student findStudentInfo(String name){
        Student student = new Student();
        String sql = "SELECT * FROM students WHERE name=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            try(ResultSet rst =  pstmt.executeQuery()){
                while(rst.next()) {
                    student.setName(rst.getString("name"));
                    student.setSchool_id(rst.getString("school_id"));
                    student.setId(rst.getString("id"));
                    student.setClass1(rst.getString("class1"));
                    student.setCollege(rst.getString("college"));
                    student.setMajor(rst.getString("major"));
                    student.setAttendenceRecord(rst.getString("attendenceRecord"));
                }
            }
            return student;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //查找老师信息
    public Teacher findTeacherInfo(String school_id){
        Teacher teacher = new Teacher();
        String sql = "SELECT * FROM teachers WHERE school_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            try(ResultSet rst =  pstmt.executeQuery()){
                while(rst.next()) {
                    teacher.setName(rst.getString("name"));
                    teacher.setSchool_id(rst.getString("school_id"));
                    teacher.setId(rst.getString("id"));
                    teacher.setRole(rst.getString("role"));
                    teacher.setCollege(rst.getString("college"));
                    teacher.setAttendenceRecord(rst.getString("attendenceRecord"));
                    teacher.setPassword(rst.getString("password"));
                }
            }
            return teacher;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}
