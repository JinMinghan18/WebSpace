package com.dao;

import com.model.Student;
import com.model.Teacher;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.management.relation.Role;
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
    //列出所有学生
    public ArrayList<Student> allStudentInfo(){
        String sql = "SELECT * FROM students";
        ArrayList<Student>stuList = new ArrayList<Student>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            double sum = 0;//总计老师数
            double finished = 0;//完成打卡的老师
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Student student = new Student();
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);//获取日期

                    if(rst.getString("attendenceRecord").charAt(date2)=='0'){
                        student.setName(rst.getString("name"));
                        student.setId(rst.getString("id"));
                        student.setSchool_id(rst.getString("school_id"));
                        student.setCollege(rst.getString("college"));
                        student.setMajor(rst.getString("major"));
                        student.setClass1(rst.getString("class1"));
                        student.setAttendenceRecord("未打卡");
                        student.setHealthcode(rst.getString("healthcode"));
                        stuList.add(student);
                    }
                    else if(rst.getString("attendenceRecord").charAt(date2)!='0'){
                        student.setName(rst.getString("name"));
                        student.setId(rst.getString("id"));
                        student.setSchool_id(rst.getString("school_id"));
                        student.setCollege(rst.getString("college"));
                        student.setMajor(rst.getString("major"));
                        student.setClass1(rst.getString("class1"));
                        student.setAttendenceRecord("已打卡");
                        student.setHealthcode(rst.getString("healthcode"));
                        stuList.add(student);
                    }

                }
            }
            return stuList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //列出所有老师
    public ArrayList<Teacher> allTeacherInfo(){
        String sql = "SELECT * FROM teachers";
        ArrayList<Teacher>teaList = new ArrayList<Teacher>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            double sum = 0;//总计老师数
            double finished = 0;//完成打卡的老师
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Teacher teacher = new Teacher();
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);//获取日期

                    if(rst.getString("attendenceRecord").charAt(date2)=='0'){
                        teacher.setName(rst.getString("name"));
                        teacher.setId(rst.getString("id"));
                        teacher.setSchool_id(rst.getString("school_id"));
                        teacher.setCollege(rst.getString("college"));
                        teacher.setRole(rst.getString("role"));
                        teacher.setAttendenceRecord("未打卡");
                        teacher.setHealthcode(rst.getString("healthcode"));
                        teaList.add(teacher);
                    }
                    else if(rst.getString("attendenceRecord").charAt(date2)!='0'){
                        teacher.setName(rst.getString("name"));
                        teacher.setId(rst.getString("id"));
                        teacher.setSchool_id(rst.getString("school_id"));
                        teacher.setCollege(rst.getString("college"));
                        teacher.setRole(rst.getString("role"));
                        teacher.setAttendenceRecord("已打卡");
                        teacher.setHealthcode(rst.getString("healthcode"));
                        teaList.add(teacher);
                    }
                }
            }
            return teaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

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
    //查找学生信息
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

                    //日期
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);
                    String daysum = rst.getString("attendenceRecord");
                    String bool = "false";//统计当天是否打卡
                    if(daysum.charAt(date2)!='0'){
                        bool = "true";
                    }

                    Teacher teacher =new Teacher();
                    teacher.setAttendenceRecord(bool);
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
    //修改老师信息
    public boolean modifyTeacherInfo(String name,String id, String school_id,String college,String healthcode,String password,String role){
        String sql = "UPDATE teachers SET name=?,id=?,school_id=?,college=?,role=?, attendenceRecord=?,password=?,healthday=?,healthcode=? WHERE name=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            String attendenceRecord = "0000000000000000000000000000000";//默认未打卡

            Date d1 = new Date();
            SimpleDateFormat dfd = new SimpleDateFormat("dd");
            String date = dfd.format(d1);
            int date2 = Integer.parseInt(date);//获取日期
            int healthday = 7;//默认打卡满七天
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
            pstmt.setString(1,name);
            pstmt.setString(2,id);
            pstmt.setString(3,school_id);
            pstmt.setString(4,college);
            pstmt.setString(5,role);
            pstmt.setString(6,attendenceRecord);
            pstmt.setString(7,password);
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
    public boolean deleteStudent(String name){
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
    //新增老师记录
    public boolean addTeacher(Teacher teacher){
        String sql = "INSERT INTO teachers" + "(name,id,school_id,college,role,attendenceRecord,password,healthday,healthcode)VALUES(?,?,?,?,?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getId());
            pstmt.setString(3, teacher.getSchool_id());
            pstmt.setString(4, teacher.getCollege());
            pstmt.setString(5, teacher.getRole());
            pstmt.setString(6, "0000000000000000000000000000000");
            pstmt.setString(7,teacher.getPassword());
            pstmt.setInt(8,0);
            pstmt.setString(9,teacher.getHealthcode());
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
    //批量导入老师
    public boolean addMoreTeacher(String str){
        String sql = "INSERT INTO teachers" + "(name,id,school_id,college,role,attendenceRecord,password,healthday,healthcode)VALUES(?,?,?,?,?,?,?,?,?)";
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
                pstmt.setString(6,"0000000000000000000000000000000");

                pstmt.setString(7,result[5]);
                pstmt.setInt(8,0);
                pstmt.setString(9,null);
//                System.out.println(result[1]);
                pstmt.executeUpdate();
            }
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //统计老师打卡率
    public double teacherDailyAttendence(){
        String sql = "SELECT * FROM teachers";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            double sum = 0;//总计老师数
            double finished = 0;//完成打卡的老师
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    sum++;
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);//获取日期

                    if(rst.getString("attendenceRecord").charAt(date2)!='0'){
                        finished++;
                    }
                }
            }
            return finished/sum;
        }catch (SQLException se){
            se.printStackTrace();
            return 0;
        }
    }
    //统计学生打卡率
    public double studentDailyAttendence(){
        String sql = "SELECT * FROM students";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            double sum = 0;//总计老师数
            double finished = 0;//完成打卡的老师
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    sum++;

                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);//获取日期

                    if(rst.getString("attendenceRecord").charAt(date2)!='0'){
                        finished++;
                    }
                }
            }
            return finished/sum;
        }catch (SQLException se){
            se.printStackTrace();
            return 0;
        }
    }
    //未打卡的学生
    public ArrayList<Student> findUnfinishedStudent(){
        String sql = "SELECT * FROM students";
        ArrayList<Student>stuList = new ArrayList<Student>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            double sum = 0;//总计老师数
            double finished = 0;//完成打卡的老师
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Student student = new Student();
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);//获取日期

                    if(rst.getString("attendenceRecord").charAt(date2)=='0'){
                        student.setName(rst.getString("name"));
                        student.setId(rst.getString("id"));
                        student.setSchool_id(rst.getString("school_id"));
                        student.setCollege(rst.getString("college"));
                        student.setMajor(rst.getString("major"));
                        student.setClass1(rst.getString("class1"));
                        student.setAttendenceRecord("未打卡");
                        student.setHealthcode(rst.getString("healthcode"));
                        stuList.add(student);
                    }

                }
            }
            return stuList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //未打卡的老师
    public ArrayList<Teacher> findUnfinishedTeacher(){
        String sql = "SELECT * FROM teachers";
        ArrayList<Teacher>teaList = new ArrayList<Teacher>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            double sum = 0;//总计老师数
            double finished = 0;//完成打卡的老师
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Teacher teacher = new Teacher();
                    Date d1 = new Date();
                    SimpleDateFormat dfd = new SimpleDateFormat("dd");
                    String date = dfd.format(d1);
                    int date2 = Integer.parseInt(date);//获取日期

                    if(rst.getString("attendenceRecord").charAt(date2)=='0'){
                        teacher.setName(rst.getString("name"));
                        teacher.setId(rst.getString("id"));
                        teacher.setSchool_id(rst.getString("school_id"));
                        teacher.setCollege(rst.getString("college"));
                        teacher.setRole(rst.getString("role"));
                        teacher.setAttendenceRecord("未打卡");
                        teacher.setHealthcode(rst.getString("healthcode"));
                        teaList.add(teacher);
                    }

                }
            }
            return teaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //判断是否为老师（打卡的时候）
    public boolean isTeacher(String school_id){
        String sql = "SELECT * FROM teachers WHERE school_id=?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst!=null)
                    return true;
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }
    //判断是否为学生（打卡的时候）
    public boolean isStudent(String school_id){
        String sql = "SELECT * FROM students WHERE school_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst!=null)
                    return true;
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return false;
    }
}
