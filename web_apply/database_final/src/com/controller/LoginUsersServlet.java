package com.controller;

import com.dao.highSchoolDao;
import com.model.Admin;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Highlighter;
import java.io.IOException;

@WebServlet({"/LoginUsersServlet"})
public class LoginUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String school_id = request.getParameter("school_id");
        String password = request.getParameter("password");
        if(type.equals("admin")){
            highSchoolDao dao = new highSchoolDao();
            Admin admin = dao.findAdmininfo(school_id);
            if(password.equals(admin.getApass().trim())){
                //进入管理员界面
                System.out.println("admin");
                RequestDispatcher rd = request.getRequestDispatcher("/JSP/test.jsp");
                rd.forward(request,response);
            }
        }
        else if(type.equals("teacher")){
            highSchoolDao dao = new highSchoolDao();
            Teacher teacher = dao.findTeacherinfo(school_id);
            if(password.equals(teacher.getTpass().trim())){
                //进入教师界面
                System.out.println("tea");
                RequestDispatcher rd = request.getRequestDispatcher("/JSP/test.jsp");
                rd.forward(request,response);
            }
        }
        else if(type.equals("student")){
            highSchoolDao dao = new highSchoolDao();
            Student student= dao.findStudentinfo(school_id);
            if(password.equals(student.getSpass().trim())){
                //进入学生界面
                System.out.println("stu");
                RequestDispatcher rd = request.getRequestDispatcher("/JSP/test.jsp");
                rd.forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
