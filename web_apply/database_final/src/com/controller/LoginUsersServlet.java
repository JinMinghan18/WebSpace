package com.controller;

import com.dao.SchoolDao;
import com.model.Admin;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/LoginUsersServlet"})
public class LoginUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String school_id = request.getParameter("school_id");
        String password = request.getParameter("password");
        if(type.equals("admin")){
            SchoolDao dao = new SchoolDao();
            Admin admin = dao.loginAdmin(school_id);
            if(password.equals(admin.getApass().trim())){
                //进入管理员界面
                System.out.println("admin");
                RequestDispatcher rd = request.getRequestDispatcher("/JSP/allAdministrators2.jsp");
                rd.forward(request,response);
            }
        }
        else if(type.equals("teacher")){
            SchoolDao dao = new SchoolDao();
            Teacher teacher = dao.loginTeacher(school_id);
            if(password.equals(teacher.getTpass().trim())){
                //进入教师界面
                System.out.println("tea");
                RequestDispatcher rd = request.getRequestDispatcher("/JSP/test.jsp");
                rd.forward(request,response);
            }
        }
        else if(type.equals("student")){
            SchoolDao dao = new SchoolDao();
            Student student= dao.loginStudent(school_id);
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
