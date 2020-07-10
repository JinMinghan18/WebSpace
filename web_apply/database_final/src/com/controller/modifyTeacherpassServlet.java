package com.controller;

import com.dao.SchoolDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/modifyTeacherpassServlet"})
public class modifyTeacherpassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        SchoolDao dao = new SchoolDao();
        String tno = request.getParameter("tno");
        String tname = request.getParameter("tname");
        String tsex = request.getParameter("tsex");
        String tage = request.getParameter("tage");
        String ttitle = request.getParameter("ttitle");
        String ttel = request.getParameter("ttel");
        String tpass = request.getParameter("tpass");
        String tnoold = request.getParameter("tnoold");
        request.setAttribute("tno",tno);
        boolean issuccess = dao.modTeacher(tno,tname,tsex,Integer.parseInt(tage),ttitle,ttel,tpass,tnoold);
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/Teacher.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
