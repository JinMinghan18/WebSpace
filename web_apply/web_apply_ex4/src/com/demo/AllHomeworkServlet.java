package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet({"/Homework.html"})
public class AllHomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String filepath = this.getServletContext().getRealPath("/homework.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"utf-8"));



        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h4 align='center'>已上传的作业</h4>");

        out.println("<table><tr><td align=\"center\">序号</td><td align=\"center\">学号</td><td align=\"center\">姓名</td><td align=\"center\">作业标题</td><td align=\"center\">上传时间</td><td>下载</td></tr>");
        String str = br.readLine();
        int i = 1;
        while(str!=null || str!=""){
            String []info = str.split("\\t");
            out.println("<tr>");
            out.println("<td align=\"center\">"+i+"</td>");
            out.println("<td align=\"center\">"+info[0]+"</td>");
            out.println("<td align=\"center\">"+info[1]+"</td>");
            out.println("<td align=\"center\">"+info[2]+"</td>");
            out.println("<td align=\"center\">"+info[3]+"</td>");
            String path="downloadHomework.do?userid="+info[0]+"&filename="+info[4];
            out.println("<td align=\"center\"><a href=\""+path+"\">下载</a></td>");
            out.println("</tr>");
            i++;
            str = br.readLine();
        }
        out.println("</table>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
