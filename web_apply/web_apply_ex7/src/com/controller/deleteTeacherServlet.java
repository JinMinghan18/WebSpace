package com.controller;

import com.dao.HealthCodeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/deleteTeacher"})
public class deleteTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HealthCodeDao dao = new HealthCodeDao();
        String message = null;
        try{
            String name = request.getParameter("name");
            boolean success = dao.deleteTeacher(name);
            if (success) {
                message = "<li>删除成功！</li>";
            } else {
                message = "<li>删除失败</li>";
            }
        }catch (Exception e) {
            message = "<li>出现异常</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAllTeacher.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
