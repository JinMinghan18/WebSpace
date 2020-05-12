package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet({"/LoginAction2"})
public class LoginAction2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        boolean isRight2 = false;
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String dataDirectory =
                request.getServletContext().getRealPath("/WEB-INF/files");
        File file = new File(dataDirectory,"user.txt");
        BufferedReader br = null;
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
        br = new BufferedReader(reader);

        String str2 = null;
        str2 = br.readLine();
        while(str2!=null){
            int[] pos = new int[10];
            int cnt = 0;
            for(int i = 0;i < str2.length();i++){
                if(str2.charAt(i)==' '){
                    pos[cnt] = i;
                    cnt++;
                }
            }
            String Id2 = str2.substring(0,pos[0]);
            String Password2 = str2.substring(pos[0]+1,pos[1]);
            String Name2 = str2.substring(pos[1]+1,pos[2]);
            String Type2 = str2.substring(pos[2]+1);
            if(Id2.equals(id) && Password2.equals(password) && Type2.equals("学生")){
                isRight2 = true;
                UserBean userBean = new UserBean(Id2,Password2,Name2,Type2);
                HttpSession session = request.getSession();
                synchronized (session){
                    session.setAttribute("userBean",userBean);
                }
                response.sendRedirect("UploadAndDownload/studentOperation.jsp");
                break;
            }
            if(Id2.equals(id) && Password2.equals(password) && Type2.equals("教师")){
                isRight2 = true;
                UserBean userBean = new UserBean(Id2,Password2,Name2,Type2);
                HttpSession session = request.getSession();
                synchronized (session){
                    session.setAttribute("userBean",userBean);
                }
                response.sendRedirect("Homework.html");
                break;
            }
            str2 = br.readLine();
        }
        if(!isRight2) response.sendRedirect("UploadAndDownload/login2.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
