package com.demo;

import javafx.application.Application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet({"/download"})
public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //用户没登录就转跳登录界面
        if(session == null || session.getAttribute("loggedIn") == null){
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request,response);
            return;
        }
        String dataDirectory =
                request.getServletContext().getRealPath("/WEB-INF/files");
        File file = new File(dataDirectory,"servlet.pdf");
        if(file.exists()){
            //设置响应的内容类型为PDF文件
            response.setContentType("Application/pdf");
            //设置Content-Disposion响应头，指定文件名
            response.addHeader("Content-Disposition","attachment;filename=servlet.pdf");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try{
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
               //返回输出流对象
                OutputStream os = response.getOutputStream();
                //读取1kb
                int i = bis.read(buffer);
                while (i != -1){
                    os.write(buffer,0,i);
                    i = bis.read(buffer);
                }
            }catch (IOException ex){
                System.out.println(ex.toString());
            }finally {
                if(bis != null){
                    bis.close();
                }
                if(fis != null){
                    fis.close();
                }
            }
        }else{
            response.setContentType("text/html;charset = UTF-8");
            PrintWriter out = response.getWriter();
            out.println("文件不存在！");
        }

    }
}
