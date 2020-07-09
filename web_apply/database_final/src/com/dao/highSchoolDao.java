package com.dao;

import com.model.Admin;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class highSchoolDao extends Basedao {

    public Admin findAdmininfo(String school_id){
        String sql = "SELECT * FROM jinmh_Admin03 WHERE jmh_Ano03=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            Admin admin = new Admin();
            try(ResultSet rst = pstmt.executeQuery()){
                while(rst.next()){
                    admin.setAno(rst.getString("jmh_Ano03"));
                    admin.setApass(rst.getString("jmh_Apass03"));
                    admin.setIdentity(rst.getString("jmh_identity03"));
                }
            }
            return admin;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public Teacher findTeacherinfo(String school_id){
        String sql = "SELECT * FROM jinmh_Teacher03 WHERE jmh_Tno03=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            Teacher teacher = new Teacher();
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    teacher.setTno(rst.getString("jmh_Tno03"));
                    teacher.setTpass(rst.getString("jmh_Tpass03"));
                }
            }
            return teacher;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public Student findStudentinfo(String school_id){
        String sql = "SELECT * FROM jinmh_Student03 WHERE jmh_Sno03=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            Student student = new Student();
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    student.setSno(rst.getString("jmh_Sno03"));
                    student.setSpass(rst.getString("jmh_Spass03"));
                }
            }
            return student;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}
