package com.controller;

import com.dao.SchoolDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/addCourseServlet"})
public class addCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SchoolDao dao = new SchoolDao();
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String cterm = request.getParameter("cterm");
        String ctime = request.getParameter("ctime");
        String cway = request.getParameter("cway");
        String ccredit = request.getParameter("ccredit");
        boolean isSuccess = dao.addCourse(cno,cname,cterm,Integer.parseInt(ctime),cway,ccredit);
        RequestDispatcher rd = request.getRequestDispatcher("queryAllCourseServlet");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
