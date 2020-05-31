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

@WebServlet({"/addStudent"})
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HealthCodeDao dao = new HealthCodeDao();
        Student student = new Student();
        String message = null;
        try{
            student.setName(request.getParameter("name"));
            student.setId(request.getParameter("id"));
            student.setSchool_id(request.getParameter("school_id"));
            student.setCollege(request.getParameter("college"));
            student.setMajor(request.getParameter("major"));
            student.setClass1(request.getParameter("class1"));
            boolean success = dao.addStudent(student);
            if(success){
                message="<li>添加成功</li>";
            }else {
                message="<li>添加失败</li>";
            }
        }catch (Exception e){
            message = "<li>出现异常</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/addStudent.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
