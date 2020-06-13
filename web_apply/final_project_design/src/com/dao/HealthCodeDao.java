package com.dao;

import com.model.Student;
import com.model.Teacher;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequestListener;
import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.AttributedCharacterIterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    //检索学生信息
    public ArrayList<Student> studentInfoQuery(String college, String major, String class1){
        ArrayList<Student>stuList = new ArrayList<Student>();

        String sql = "SELECT * FROM students WHERE college=? AND major=? AND class1=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,college);
            pstmt.setString(2,major);
            pstmt.setString(3,class1);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);
                    Student student = new Student();
                    String daysum = rst.getString("attendenceRecord");
                    String bool = "false";//统计当天是否打卡
                    if(daysum.charAt(date2)!='0'){
                        bool = "true";
                    }
                    int count = 0;//统计打卡天数
                    for(int i = 0;i < daysum.length();i++){
                        if(daysum.charAt(i)!='0')
                            count++;
                    }
                    student.setMajor(rst.getString("major"));
                    student.setCollege(rst.getString("college"));
                    student.setClass1(rst.getString("class1"));
                    student.setName(rst.getString("name"));
//                    System.out.println(rst.getString("name"));
                    student.setId(rst.getString("id"));
                    student.setSchool_id(rst.getString("school_id"));
                    student.setAttendenceRecord(bool);
                    student.setHealthcode(rst.getString("healthcode"));
                    stuList.add(student);
                }
            }
//            System.out.println(stuList.get(1).getName()+"dao");
            return stuList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //检索老师信息
    public ArrayList<Teacher> teacherInfoQuery(String college){
        ArrayList<Teacher>teaList = new ArrayList<Teacher>();

        String sql = "SELECT * FROM teachers WHERE college=? ";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,college);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Teacher teacher =new Teacher();
                    teacher.setAttendenceRecord(rst.getString("attendenceRecord"));
                    teacher.setPassword(rst.getString("Password"));
                    teacher.setRole(rst.getString("role"));
                    teacher.setCollege(rst.getString("college"));
                    teacher.setId(rst.getString("id"));
                    teacher.setSchool_id(rst.getString("school_id"));
                    teacher.setName(rst.getString("name"));
                    teacher.setHealthcode(rst.getString("healthcode"));
                    teacher.setHealthday(rst.getInt("healthday"));
                    teaList.add(teacher);
                }
            }

            return teaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //修改学生信息
    public boolean ModifyStudentInfo(String name,String id, String school_id,String college,String major, String class1,String healthcode){
        String sql = "UPDATE students SET name=?,id=?,school_id=?,college=?,major=?,class1=?,attendenceRecord=?,healthday=?,healthcode=? WHERE name=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.setString(2,id);
            pstmt.setString(3,school_id);
            pstmt.setString(4,college);
            pstmt.setString(5,major);

            Date d1 = new Date();
            SimpleDateFormat dfd = new SimpleDateFormat("dd");
            String date = dfd.format(d1);
            int date2 = Integer.parseInt(date);//获取日期

            String attendenceRecord = "0000000000000000000000000000000";//默认未打卡
            int healthday = 7;
            if(healthcode.equals("红码")){
                char[] arr = attendenceRecord.toCharArray();
                for(int i = 0;i<=date2;i++){
                    arr[i] = (char)('3');
                }
                attendenceRecord = new String(arr);
                healthday = 0;
            }
            else if(healthcode.equals("黄码")){
                char[] arr = attendenceRecord.toCharArray();
                for(int i = 0;i<=date2;i++){
                    arr[i] = (char)('2');
                }
                attendenceRecord = new String(arr);
                healthday = 0;
            }
            else if(healthcode.equals("绿码")){
                char[] arr = attendenceRecord.toCharArray();
                for(int i = 0;i<=date2;i++){
                    arr[i] = (char)('1');
                }
                attendenceRecord = new String(arr);
                healthday  = 0;
            }
            pstmt.setString(6,class1);
            pstmt.setString(7,attendenceRecord);
            pstmt.setInt(8,healthday);
            pstmt.setString(9,healthcode);
            pstmt.setString(10,name);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //删除学生信息
    public boolean deleteStudentInfo(String name){
        String sql = "DELETE FROM students WHERE name=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //新增一条学生记录
    public boolean addStudent(Student student){
        String sql = "INSERT INTO students" + "(name,id,school_id,college,major,class1,attendenceRecord,healthday,healthcode)VALUES(?,?,?,?,?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getId());
            pstmt.setString(3,student.getSchool_id());
            pstmt.setString(4,student.getCollege());
            pstmt.setString(5,student.getMajor());
            pstmt.setString(6,student.getClass1());
            pstmt.setString(7,"0000000000000000000000000000000");
            pstmt.setInt(8,0);
            pstmt.setString(9,null);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //批量导入学生
    public boolean addMoreStudent(String str){
        String sql="INSERT INTO students" + "(name,id,school_id,college,major,class1,attendenceRecord,healthday,healthcode)VALUES(?,?,?,?,?,?,?,?,?)";
        int count = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==';'){
                count++;
            }
        }
//        System.out.println(count);
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
                pstmt.setString(7,"0000000000000000000000000000000");
                pstmt.setInt(8,0);
                pstmt.setString(9,null);
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
