package com.demo;

import com.sun.javaws.progress.PreloaderDelegate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(userName != null && userName.equals("admin") && password != null && password.equals("123456")){
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn",Boolean.TRUE);
            response.sendRedirect("download");
            return;
        }else{
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/JSP/login.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
