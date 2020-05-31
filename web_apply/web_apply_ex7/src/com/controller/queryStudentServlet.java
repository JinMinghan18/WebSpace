package com.controller;

import com.dao.HealthCodeDao;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/queryStudent"})
public class queryStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Student> student = new ArrayList<Student>();
        HealthCodeDao dao = new HealthCodeDao();
        String college = request.getParameter("college");
        System.out.println(college);
        String major = request.getParameter("major");
        System.out.println(major);
        String class1 = request.getParameter("class1");
        System.out.println(class1);
        student = dao.findStudent(college,major,class1);
        request.setAttribute("student",student);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/showquerystudent.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
