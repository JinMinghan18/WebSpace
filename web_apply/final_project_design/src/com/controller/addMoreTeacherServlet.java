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

@WebServlet({"/addMoreTeacherServlet"})
public class addMoreTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HealthCodeDao dao = new HealthCodeDao();
        Teacher teacher = new Teacher();
        try{
            String str = request.getParameter("added");
            System.out.println(str);
            boolean success = dao.addMoreTeacher(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/AddTeacherInfo.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
