package com.controller;

import com.dao.HealthCodeDao;
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        String school_id = request.getParameter("school_id");
        System.out.println(school_id);
        String id = request.getParameter("id");
        System.out.println(id);
        HealthCodeDao dao = new HealthCodeDao();
        Student student = dao.findStudentInfo(name);
        Teacher teacher = dao.findTeacherInfo(name);
        System.out.println("studentinfo"+student.getName());
        System.out.println(student.getId());
        System.out.println(student.getSchool_id());
        System.out.println("teacberinfo"+teacher.getName());
        System.out.println(teacher.getId());
        System.out.println(teacher.getSchool_id());
        request.setAttribute("student",student);
        request.setAttribute("teacher",teacher);
        if(student==null && teacher==null){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/error.jsp");
            rd.forward(request,response);
        }
        else if(student!=null && (!school_id.equals(student.getSchool_id()) || !id.equals(student.getId()))){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/error.jsp");
            rd.forward(request,response);
        }
        else if(teacher!=null && (!school_id.equals(teacher.getSchool_id()) || !id.equals(teacher.getId()))){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/error.jsp");
            rd.forward(request,response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/HealthCode.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
