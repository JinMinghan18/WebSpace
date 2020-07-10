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

//查询所有教师信息
    public ArrayList<Teacher> QueryAllTeacher(){
        String sql = "SELECT * FROM jinmh_Teacher03";
        ArrayList<Teacher>teaList = new ArrayList<Teacher>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Teacher teacher = new Teacher();
                    teacher.setTno(rst.getString("jmh_Tno03"));
                    teacher.setTname(rst.getString("jmh_Tname03"));
                    teacher.setTsex(rst.getString("jmh_Tsex03"));
                    teacher.setTage(rst.getInt("jmh_Tage03"));
                    teacher.setTtitle(rst.getString("jmh_Ttitle03"));
                    teacher.setTtel(rst.getString("jmh_Ttel03"));
                    teacher.setTpass(rst.getString("jmh_Tpass03"));
                    teaList.add(teacher);
                }
            }
            return teaList;
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

//按工号查询老师信息
    public ArrayList<Teacher> QueryTeacher(String school_id){
        String sql = "SELECT * FROM jinmh_Teacher03 WHERE jmh_Tno03=?";
        ArrayList<Teacher> teaList = new ArrayList<Teacher>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Teacher teacher = new Teacher();
                    teacher.setTno(rst.getString("jmh_Tno03"));
                    teacher.setTname(rst.getString("jmh_Tname03"));
                    teacher.setTsex(rst.getString("jmh_Tsex03"));
                    teacher.setTage(rst.getInt("jmh_Tage03"));
                    teacher.setTtitle(rst.getString("jmh_Ttitle03"));
                    teacher.setTtel(rst.getString("jmh_Ttel03"));
                    teacher.setTpass(rst.getString("jmh_Tpass03"));
                    teaList.add(teacher);
                }
            }
            return teaList;
        }catch (SQLException se ){
            se.printStackTrace();
            return null;
        }
    }
//添加学生信息
    public boolean addStudent(String sno, String bno, String sname, String sex, int sage, String shome, String spoint ,String spass){
        String sql = "INSERT INTO jinmh_Student03 VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,sno);
            pstmt.setString(2,bno);
            pstmt.setString(3,sname);
            pstmt.setString(4,sex);
            pstmt.setInt(5,sage);
            pstmt.setString(6,shome);
            pstmt.setInt(7,Integer.parseInt(spoint));
            pstmt.setString(8,spass);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }

//添加教师信息
    public boolean addTeacher(String tno, String tname, String tsex, int tage, String ttitle, String ttel, String tpass){
    String sql = "INSERT INTO jinmh_Teacher03 VALUES(?,?,?,?,?,?,?)";
    try(Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1,tno);
        pstmt.setString(2,tname);
        pstmt.setString(3,tsex);
        pstmt.setInt(4,tage);
        pstmt.setString(5,ttitle);
        pstmt.setString(6,ttel);
        pstmt.setString(7,tpass);

        pstmt.executeUpdate();
    }catch (SQLException se){
        se.printStackTrace();
        return false;
    }
    return true;
}
//删除学生信息
    public boolean delStudent(String school_id){
    String sql = "DELETE FROM jinmh_Student03 WHERE jmh_Sno03=?";
    try(Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1,school_id);
        pstmt.executeUpdate();
        return true;
    }catch (SQLException se){
        se.printStackTrace();
        return false;
    }
}

//删除教师信息
public boolean delTeacher(String school_id){
    String sql = "DELETE FROM jinmh_Teacher03 WHERE jmh_Tno03=?";
    try(Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1,school_id);
        pstmt.executeUpdate();
        return true;
    }catch (SQLException se){
        se.printStackTrace();
        return false;
    }
}

//修改学生信息（学号）
    public boolean modStudent1(String sno, String bno, String sname, String sex, int sage, String shome, String spoint , String spass ,String snoold){
        String sql = "UPDATE jinmh_Student03 SET jmh_Sno03=?,jmh_Bno03=?,jmh_Sname03=?,jmh_Ssex03=?,jmh_Sage03=?,jmh_Shome03=?,jmh_Spoint03=?,jmh_Spass03=? WHERE jmh_Sno 03=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,sno);
            pstmt.setString(2,bno);
            pstmt.setString(3,sname);
            pstmt.setString(4,sex);
            pstmt.setInt(5,sage);
            pstmt.setString(6,shome);
            pstmt.setInt(7,Integer.parseInt(spoint));
            pstmt.setString(8,spass);
            pstmt.setString(9,snoold);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
//修改教师信息
    public boolean modTeacher(String tno, String tname, String tsex, int tage, String ttitle, String ttel, String tpass,String tnoold){
        String sql = "UPDATE jinmh_Teacher03 SET jmh_Tno03=?,jmh_Tname03=?,jmh_Tsex03=?,jmh_Tage03=?,jmh_Ttitle03=?,jmh_Ttel03=?,jmh_Tpass03=? WHERE jmh_Tno03=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,tno);
            pstmt.setString(2,tname);
            pstmt.setString(3,tsex);
            pstmt.setInt(4,tage);
            pstmt.setString(5,ttitle);
            pstmt.setString(6,ttel);
            pstmt.setString(7,tpass);
            pstmt.setString(8,tnoold);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
//修改管理员密码
    public boolean modAdminPass(String pass ,String ano){
        String sql = "UPDATE jinmh_Admin SET jmh_Apass03=? WHERE jmh_Ano03=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,pass);
            pstmt.setString(2,ano);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
}
