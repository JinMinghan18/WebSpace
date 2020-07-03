package com.controller;

import com.dao.HealthCodeDao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.model.HealthCode;
import com.model.MatrixToImageWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet({"/CheckHealthCodeServlet"})
public class CheckHealthCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HealthCodeDao dao = new HealthCodeDao();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        request.setAttribute("id",id);
        String school_id = request.getParameter("school_id");
        String tel = request.getParameter("tel");
        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");
        String q3 = request.getParameter("q3");
        String q4 = request.getParameter("q4");
        String[] multi1 = request.getParameterValues("situation");
        String[] multi2 = request.getParameterValues("promise");
        String a = "";
        int choice = 0;//默认绿码
        int cnt = 0;
        for(int i = 1;i<multi1.length;i++){
            if(multi1[i]!=null){
                cnt++;
            }
        }
        if(q3.equals("yes")||q4.equals("yes")||cnt>=2){
            choice = 2;//红
        }
        else if(q1.equals("no")&&q2.equals("no")&&q3.equals("no")&&q4.equals("no")&&multi1[0].equals("nothing_wrong")){
            choice = 0;
        }
        else{
            choice = 1;
        }


        HealthCode healthCode = new HealthCode(name,id,school_id,tel,choice);
        try{
            request.setAttribute("choice",choice);
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat(" HH:mm:ss");
            String time = df.format(d);
            String time2 = df2.format(d);
            String aa = "姓名"+name+"\n"+"学号(工号)"+id+"\n"+"生成时间"+time+time2;
            String path2 =  request.getContextPath();
            String path = request.getServletContext().getRealPath("/images/");

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hint = new HashMap();
            hint.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(aa, BarcodeFormat.QR_CODE,220,220,hint);
            File file1 = new File(path,"test.jpg");
            request.setAttribute("file",file1);
            MatrixToImageWriter.writeToFile(bitMatrix,"jpg",file1,choice);
        }catch(Exception e){}
        request.setAttribute("choice",choice);
        HttpSession session = request.getSession();
        synchronized (session){
            session.setAttribute("healthCode",healthCode);

        }
        boolean check_teacher = dao.isTeacher(school_id);
        boolean check_stuednt = dao.isStudent(school_id);
        if(check_stuednt!=true){

        }
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/displayHealthCode.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
