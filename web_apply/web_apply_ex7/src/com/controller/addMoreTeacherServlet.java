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

@WebServlet({"/addMoreTeacher"})
public class addMoreTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HealthCodeDao dao = new HealthCodeDao();
        Teacher teacher = new Teacher();
        String message = null;
        try{
            String str = request.getParameter("added");
            System.out.println(str);
            boolean success = dao.addMoreTeacher(str);
            if(success){
                message="<li>添加成功</li>";
            }else {
                message="<li>添加失败</li>";
            }
        }catch (Exception e){
            message = "<li>出现异常</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/addTeacher.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
