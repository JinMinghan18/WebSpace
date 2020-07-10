package com.controller;

import com.dao.SchoolDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/addTeacherServlet"})
public class addTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SchoolDao dao = new SchoolDao();
        String tno = request.getParameter("tno");
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        String tage = request.getParameter("tage");
        String ttitle = request.getParameter("ttitle");
        String ttel = request.getParameter("ttel");
        String tpass = request.getParameter("tpass");
        boolean isSuccess = dao.addTeacher(tno,tname,tsex,Integer.parseInt(tage),ttitle,ttel,tpass);
        RequestDispatcher rd = request.getRequestDispatcher("queryAllTeacherServlet");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
