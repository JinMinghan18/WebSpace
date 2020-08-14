package com.controller;

import com.dao.seebugdao;
import com.model.newpaper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.temporal.Temporal;
import java.util.ArrayList;

@WebServlet({"/selectAllNewpaperServlet"})
public class selectAllNewpaperServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        seebugdao dao = new seebugdao();
        ArrayList<newpaper> newpaperArrayList = new ArrayList<newpaper>();
        newpaperArrayList = dao.allnewpaper();
        request.setAttribute("newpaperArrayList",newpaperArrayList);
        RequestDispatcher rd = request.getRequestDispatcher("JSP/newpaper.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
