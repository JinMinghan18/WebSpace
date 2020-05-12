package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet({"/downloadHomework.do"})
public class downloadHomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/");
        path = path + "\\workNumber\\";
        request.setCharacterEncoding("UTF-8");
        String Id = request.getParameter("userid");
        String filename = request.getParameter("filename");
        HttpSession session = request.getSession();
        UserBean temp = (UserBean)session.getAttribute("userBean");
        if(temp.getType().equals("教师") || Id.equals(temp.getId())){
            path = path+filename;
            File file = new File(path);
            if(!file.exists()){
                response.setContentType("application/msword");
                response.addHeader("Content-Disposition","attachment;filename="+filename+"");
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while(i!=-1){
                        os.write(buffer,0,i);
                        i = bis.read(buffer);
                    }
                }catch (IOException ex){
                    System.out.println(ex.toString());
                }finally {
                    if(bis!=null){
                        bis.close();
                    }
                    if(fis!=null){
                        fis.close();
                    }
                }
            }else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("文件不存在");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
