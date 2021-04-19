package com.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        if(request.getParameter("username").equals("")||request.getParameter("password").equals("")){
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/fail.jsp");
            rd.forward(request,response);
        }else{
            FileWriter f=new FileWriter("D:\\MyStudySpace\\WebSpace\\software_test\\ex5\\login.txt");
            BufferedWriter br=new BufferedWriter(f);
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            br.write(username+" "+password+"\r\n");
            br.close();
            f.close();
            request.setAttribute("username",username);
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
