package com.dao;

import com.model.Admin;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;

public class SchoolDao extends Basedao {
//管理员登录
    public Admin loginAdmin(String school_id){
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
//教师登录
    public Teacher loginTeacher(String school_id){
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
//学生登录
    public Student loginStudent(String school_id){
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
//学生总数
    public int studentSum(){
        String sql = "SELECT * FROM jinmh_Student03";
        int sum = 0;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                while(rst.next()){
                    sum++;
                }
            }
            return sum;
        }catch (SQLException se){
            se.printStackTrace();
            return 0;
        }
    }
//教师总数
    public int TeacherSum(){
        String sql = "SELECT * FROM jinmh_Teacher03";
        int sum = 0;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                while(rst.next()){
                    sum++;
                }
            }
            return sum;
        }catch (SQLException se){
            se.printStackTrace();
            return 0;
        }
    }
//查询所有学生信息
    public ArrayList<Student> QueryAllStudent(){
        String sql = "SELECT * FROM jinmh_Student03";
        ArrayList<Student>stuList = new ArrayList<Student>();
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Student student = new Student();
                    student.setSno(rst.getString("jmh_Sno03"));
                    student.setSname(rst.getString("jmh_Sname03"));
                    student.setBno(rst.getString("jmh_Bno03"));
                    student.setSsex(rst.getString("jmh_Ssex03"));
                    student.setSage(rst.getInt("jmh_Sage03"));
                    student.setSpoint(rst.getString("jmh_Spoint03"));
                    student.setShome(rst.getString("jmh_Shome03"));
                    student.setSpass(rst.getString("jmh_Spass03"));
                    stuList.add(student);
                }
            }
            return stuList;
        }catch (SQLException se ){
            se.printStackTrace();
            return null;
        }
    }
//按学号查询学生信息
    public ArrayList<Student> QueryStudent(String school_id){
        String sql = "SELECT * FROM jinmh_Student03 WHERE jmh_Sno03=?";
        ArrayList<Student> stuList = new ArrayList<Student>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Student student = new Student();
                    student.setSno(rst.getString("jmh_Sno03"));
                    student.setSname(rst.getString("jmh_Sname03"));
                    student.setBno(rst.getString("jmh_Bno03"));
                    student.setSsex(rst.getString("jmh_Ssex03"));
                    student.setSage(rst.getInt("jmh_Sage03"));
                    student.setSpoint(rst.getString("jmh_Spoint03"));
                    student.setShome(rst.getString("jmh_Shome03"));
                    student.setSpass(rst.getString("jmh_Spass03"));
                    stuList.add(student);
                }
            }
            return stuList;
        }catch (SQLException se ){
            se.printStackTrace();
            return null;
        }
    }

    public boolean addStudent(String sno, String sname, String bno, String sex, int sage, String shome, String spoint ,String spass){
        String sql = "INSERT INTO jinmh_Student03 VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,sno);
            pstmt.setString(2,bno);
            pstmt.setString(3,sname);
            pstmt.setString(4,sex);
            pstmt.setInt(5,sage);
            pstmt.setString(6,shome);
            pstmt.setString(7,spoint);
            pstmt.setString(8,spass);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
}
