package com.controller;

import com.dao.seebugdao;
import com.model.newbug;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/selectAllNewbugServlet"})
public class selectAllNewbugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<newbug>newbugArrayList = new ArrayList<newbug>();
        seebugdao dao = new seebugdao();
        newbugArrayList = dao.allnewbugInfo();
        request.setAttribute("newbugArrayList",newbugArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("JSP/newbug.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
