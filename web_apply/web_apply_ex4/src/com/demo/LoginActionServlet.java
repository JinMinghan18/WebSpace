package com.demo;

import sun.text.normalizer.UTF16;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

@WebServlet({"/LoginAction"})
public class LoginActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        boolean isRight = false;
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String dataDirectory =
                request.getServletContext().getRealPath("/WEB-INF/files");
        File file = new File(dataDirectory,"user.txt");
        BufferedReader br = null;
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
        br = new BufferedReader(reader);

        String str1 = null;
        str1 = br.readLine();
        while (str1!=null){
            int[] pos = new int[10];
            int cnt = 0;
            for(int i = 0;i < str1.length();i++){
                if(str1.charAt(i)==' '){
                    pos[cnt] = i;
                    cnt++;
                }
            }
            String Id = str1.substring(0,pos[0]);
            String Password = str1.substring(pos[0]+1,pos[1]);
            String Name = str1.substring(pos[1]+1,pos[2]);
            String Type = str1.substring(pos[2]+1);
            if(Id.equals(id) && Password.equals(password)){
                isRight = true;
                UserBean userBean = new UserBean(Id,Password,Name,Type);
                HttpSession session = request.getSession();
                synchronized (session){
                    session.setAttribute("userBean",userBean);
                }
                if(Type.equals("学生")){
                    response.sendRedirect("LoginSystem/student.jsp");
                }
                else if(Type.equals("教师")) {
                    response.sendRedirect("LoginSystem/teacher.jsp");
                }
                break;
            }
            str1 = br.readLine();
        }
        if(!isRight) response.sendRedirect("LoginSystem/login1.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
