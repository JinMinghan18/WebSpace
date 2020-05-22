package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/computeAvgScorePoint.do")
public class ScorePointServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ScorePointServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        double aa = 0;
        double bb = 0;
        double cc = 0;
        try
        {
            aa = Double.parseDouble(a);
        }catch(Exception e)
        {
            out.println("输入的成绩或学分有误！");
        }
        try
        {
            bb = Double.parseDouble(b);
        }catch(Exception e)
        {
            out.println("输入的成绩或学分有误！");
        }
        try
        {
            cc = Double.parseDouble(c);
        }catch(Exception e)
        {
            out.println("输入的成绩或学分有误！");
        }
        double temp=0;
        if(aa>=60) temp+=(aa-60)/10.0 +1;
        else if(bb>=60) temp+=(bb-60)/10.0 +1;
        else if(cc>=60) temp+=(cc-60)/10.0 +1;
        temp=temp*3/9.0;
        out.println("三门课的平均绩点为："+temp);
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
