package com.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        FileReader f=new FileReader("D:\\MyStudySpace\\WebSpace\\software_test\\ex5\\login.txt");
        BufferedReader br=new BufferedReader(f);
        boolean flag= false;
        String str;
        while((str=br.readLine())!=null) {
            String[] arr = str.split("\\s");
            if (request.getParameter("username").equals(arr[0]) && request.getParameter("password").equals((arr[1]))) {
                flag = true;
                break;
            }
        }
        br.close();
        f.close();
        if(flag){
            String username=request.getParameter("username");
            request.setAttribute("username",username);
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request,response);
        }else{
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/fail.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
