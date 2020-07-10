package com.dao;

import com.model.*;

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

//查询所有课程
    public ArrayList<Course> QueryAllCourse(){
        String sql = "SELECT * FROM jinmh_Course03";
        ArrayList<Course>courseList = new ArrayList<Course>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Course course = new Course();
                    course.setCno(rst.getString("jmh_Cno03"));
                    course.setCname(rst.getString("jmh_Cname03"));
                    course.setCterm(rst.getString("jmh_Cterm03"));
                    course.setCtime(rst.getInt("jmh_Ctime03"));
                    course.setCway(rst.getString("jmh_Cway03"));
                    course.setCcredit(rst.getString("jmh_Ccredit03"));
                    courseList.add(course);
                }
            }
            return courseList;
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

    //查询教师单个
    public Teacher QueryTeacher1(String school_id){
        String sql = "SELECT * FROM jinmh_Teacher03 WHERE jmh_Tno03=?";
        Teacher teacher = new Teacher();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    teacher.setTno(rst.getString("jmh_Tno03"));
                    teacher.setTname(rst.getString("jmh_Tname03"));
                    teacher.setTsex(rst.getString("jmh_Tsex03"));
                    teacher.setTage(rst.getInt("jmh_Tage03"));
                    teacher.setTtitle(rst.getString("jmh_Ttitle03"));
                    teacher.setTtel(rst.getString("jmh_Ttel03"));
                    teacher.setTpass(rst.getString("jmh_Tpass03"));
                }
            }
            return teacher;
        }catch (SQLException se ){
            se.printStackTrace();
            return null;
        }
    }
    //查询学生单个
    public Student QueryStudent1(String school_id){
        String sql = "SELECT * FROM jinmh_Student03 WHERE jmh_Sno03=?";
        Student student = new Student();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    student.setSno(rst.getString("jmh_Sno03"));
                    student.setSname(rst.getString("jmh_Sname03"));
                    student.setBno(rst.getString("jmh_Bno03"));
                    student.setSsex(rst.getString("jmh_Ssex03"));
                }
            }
            return student;
        }catch (SQLException se ){
            se.printStackTrace();
            return null;
        }
    }
//按课程编号查询课程信息
    public ArrayList<Course> QueryCourse(String school_id){
        String sql = "SELECT * FROM jinmh_Course03 WHERE jmh_Cno03=?";
        ArrayList<Course>courseList = new ArrayList<Course>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Course course = new Course();
                    course.setCno(rst.getString("jmh_Cno03"));
                    course.setCname(rst.getString("jmh_Cname03"));
                    course.setCterm(rst.getString("jmh_Cterm03"));
                    course.setCtime(rst.getInt("jmh_Ctime03"));
                    course.setCway(rst.getString("jmh_Cway03"));
                    course.setCcredit(rst.getString("jmh_Ccredit03"));
                    courseList.add(course);
                }
            }
            return courseList;
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

//添加课程信息
    public boolean addCourse(String cno, String cname, String cterm, int ctime, String cway, String ccredit){
        String sql = "INSERT INTO jinmh_Course03 VALUES(?,?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,cno);
            pstmt.setString(2,cname);
            pstmt.setString(3,cterm);
            pstmt.setInt(4,ctime);
            pstmt.setString(5,cway);
            pstmt.setString(6,ccredit);
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
//删除课程信息
    public boolean delCourse(String school_id){
    String sql = "DELETE FROM jinmh_Course03 WHERE jmh_Cno03=?";
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
        String sql = "UPDATE jinmh_Admin03 SET jmh_Apass03=? WHERE jmh_Ano03=?";
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
//修改学生密码
    public boolean modStudentPass(String pass ,String sno){
        String sql = "UPDATE jinmh_Student03 SET jmh_Spass03=? WHERE jmh_Sno03=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,pass);
            pstmt.setString(2,sno);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
}
//修改课程信息
    public boolean modCourse(String cno, String cname, String cterm, int ctime, String cway, String ccredit,String cnoold){
        String sql = "UPDATE jinmh_Course03 SET jmh_Cno03=?,jmh_Cname03=?,jmh_Cterm03=?,jmh_Ctime03=?,jmh_Cway03=?,jmh_Ccredit03=? WHERE jmh_Cno03=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,cno);
            pstmt.setString(2,cname);
            pstmt.setString(3,cterm);
            pstmt.setInt(4,ctime);
            pstmt.setString(5,cway);
            pstmt.setInt(6,Integer.parseInt(ccredit));
            pstmt.setString(7,cnoold);
            pstmt.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return true;
    }
//生源地统计
    public ArrayList<Shome> countStudentHome(){
        String sql = "SELECT jmh_Shome03,COUNT(jmh_Shome03) stunum from jinmh_Student03 group by jmh_Shome03";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            ArrayList<Shome> shome = new ArrayList<Shome>();
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Shome shome1 = new Shome();
                    shome1.setShome(rst.getString("jmh_Shome03"));
                    shome1.setCount(rst.getInt("stunum"));
                    shome.add(shome1);
                }

            }
            return shome;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }

    }

//班级课表查询
    public ArrayList<BanjiCourse> queryBanjiCourse(String bno){
        String sql = "SELECT jmh_Cname03,jmh_Cno03,jmh_Bno03,jmh_Bname03 " +
                "FROM jinmh_Course03,jinmh_Banji03 " +
                "WHERE jmh_Cno03 IN " +
                "(SELECT jmh_Cno03 " +
                "FROM jinmh_Lesson03 " +
                "WHERE jmh_Bno03=?) AND jmh_Bno03=?";
        ArrayList<BanjiCourse>banjiCoursesList = new ArrayList<BanjiCourse>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,bno);
            pstmt.setString(2,bno);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    BanjiCourse banjiCourse = new BanjiCourse();
                    banjiCourse.setCno(rst.getString("jmh_Cno03"));
                    banjiCourse.setCname(rst.getString("jmh_Cname03"));
                    banjiCourse.setBno(rst.getString("jmh_Bno03"));
                    banjiCourse.setBname(rst.getString("jmh_Bname03"));
                    banjiCoursesList.add(banjiCourse);
                }
            }
            return banjiCoursesList;
        }catch (SQLException se ){
            se.printStackTrace();
            return null;
        }
    }

//教师查询课程成绩排序
    public ArrayList<CourseReport> queryCourseReport(String cno){
        String sql="SELECT [学号]" +
                "      ,[姓名]" +
                "      ,[课程编号]" +
                "      ,[课程名称]" +
                "      ,[成绩]" +
                "  FROM [jinminghanMIS03].[dbo].[jinmh_Record03]" +
                "  WHERE [课程名称]=?" +
                "  ORDER BY [成绩] DESC";

        ArrayList<CourseReport> courseReportList = new ArrayList<CourseReport>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,cno);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    CourseReport cr = new CourseReport();
                    cr.setCname(rst.getString("课程名称"));
                    cr.setSno(rst.getString("学号"));
                    cr.setSname(rst.getString("姓名"));
                    cr.setGrade(rst.getInt("成绩"));
                    cr.setCno(rst.getString("课程编号"));
                    courseReportList.add(cr);
                }
            }
            return courseReportList;
        }catch (SQLException se){
            se.printStackTrace();
            return  null;
        }
    }

//查找开课学期
    public String findCterm(String cno){
        String sql = "SELECT jmh_Cterm03 FROM jinmh_Course03 WHERE jmh_Cno03=?";
        String cterm = "";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cno);
            ArrayList<String> list = new ArrayList<String>();
            try(ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                     cterm = rst.getString("jmh_Cterm03");
                }
            }
            return cterm;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
//查找课程名称
    public String findCname(String cno){
        String sql = "SELECT jmh_Cname03 FROM jinmh_Course03 WHERE jmh_Cno03=?";
        String cname = "";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cno);
            ArrayList<String> list = new ArrayList<String>();
            try(ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    cname = rst.getString("jmh_Cname03");
                }
            }
            return cname;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
//插入新成绩记录
    public boolean addStudentCourseReport(String sno,String cno,String grade,String tno) {
        String sql = "INSERT INTO jinmh_Report03 VALUES(?,?,?,?,?,?)";
        SchoolDao dao = new SchoolDao();
        String cterm = dao.findCterm(cno);
        String cname = dao.findCname(cno);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            pstmt.setString(2, cno);
            pstmt.setString(3, tno);
            pstmt.setString(4, cname);
            pstmt.setString(5, cterm);
            pstmt.setString(6, grade);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    //教师课表查询
    public ArrayList<TeacherCourse> queryTeacherCourse(String tno){
        String sql = "SELECT DISTINCT [课程编号]" +
                "      ,[课程名称]" +
                "      ,[教师编号]" +
                "      ,[任课教师]" +
                "  FROM [jinminghanMIS03].[dbo].[jinmh_Statistic03]" +
                "  WHERE [教师编号]=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,tno);
            ArrayList<TeacherCourse> teacherCourseList = new ArrayList<TeacherCourse>();
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    TeacherCourse ts = new TeacherCourse();
                    ts.setCname(rst.getString("课程名称"));
                    ts.setTname(rst.getString("任课教师"));
                    ts.setCno(rst.getString("课程编号"));
                    ts.setTno(rst.getString("教师编号"));
                    teacherCourseList.add(ts);
                }
            }
            return teacherCourseList;
        }catch (SQLException se){
            se.printStackTrace();
            return  null;
        }

    }
    //查AVG成绩
    public ArrayList<AVG> queryCourseAVG(String cno) {
        String sql = "SELECT [课程编号]" +
                "      ,[平均成绩]" +
                "  FROM [jinminghanMIS03].[dbo].[jinmh_AVG03]" +
                "  WHERE [课程编号]=?";
        ArrayList<AVG> avglist = new ArrayList<AVG>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cno);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    AVG avg = new AVG();
                    avg.setCno(rst.getString("课程编号"));
                    avg.setAvg(rst.getInt("平均成绩"));
                    avglist.add(avg);
                }
            }
            return avglist;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
//学生按学期查询课程
    public ArrayList<StudentCourse> queryStudentCourse(String sno,String cterm){
        String sql="SELECT [学号]" +
                "      ,[姓名]" +
                "      ,[开课学期]" +
                "      ,[课程名称]" +
                "      ,[成绩]" +
                "      ,[任课教师]" +
                "  FROM [jinminghanMIS03].[dbo].[jinmh_Statistic03]" +
                "  WHERE [开课学期]=? AND [学号]=?";
        ArrayList<StudentCourse>studentCourseArrayList = new ArrayList<StudentCourse>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,cterm);
            pstmt.setString(2,sno);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    StudentCourse studentCourse = new StudentCourse();
                    studentCourse.setCname(rst.getString("课程名称"));
                    studentCourse.setSno(rst.getString("学号"));
                    studentCourse.setSname(rst.getString("姓名"));
                    studentCourse.setTname(rst.getString("任课教师"));
                    studentCourse.setCterm(rst.getString("开课学期"));
                    studentCourse.setGrade(rst.getInt("成绩"));
                    studentCourseArrayList.add(studentCourse);
                }
            }
            return studentCourseArrayList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}
