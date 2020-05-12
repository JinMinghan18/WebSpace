package com.demo;

import sun.nio.cs.US_ASCII;
import sun.plugin.cache.JarCacheUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.LongToDoubleFunction;

@WebServlet({"/upload"})
@MultipartConfig(location = "D:\\",fileSizeThreshold = 1024*10240)
public class FileUploadServlet extends HttpServlet {
    //获取文件名
    private String getFileName(Part part){
        String fileName = null;
        //返回上传文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        //返回不带路径的文件名
        fileName = header.substring(header.lastIndexOf("=")+2,header.length()-1);
        return fileName;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = this.getServletContext().getRealPath("/");
        String path2 = path;
        String workNumber = request.getParameter("workNumber");
        Part p = request.getPart("fileName");
        String message = "";
        if(p.getSize()>1024*10000){//文件大小限制
            p.delete();
            message = "文件太大不能上传";
        }else{
            //存到子目录里
            path = path + "\\workNumber\\" + workNumber;
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            String fileName = getFileName(p);
            String newname = null;
            HttpSession session = request.getSession();
            UserBean userBean = (UserBean) session.getAttribute("userBean");
            String id = (String)userBean.getId();
            Long ts = new java.util.Date().getTime()/1000;
            String time = ts.toString();

            path2 = path2+"\\"+"homework.txt";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path2),true),"utf-8"));
            Date d = new Date();
            d.setTime(ts*1000);
            String time2 = new SimpleDateFormat().format(d);
            String content = userBean.getId()+"\t"+userBean.getName()+"\t"+ workNumber+"\t"+time2+"\t"+id+"_"+time+".doc\n";
            bw.write(content);
            bw.flush();
            bw.close();
            p.write(path+"\\"+id+"_"+time+".doc");
            message = "文件上传成功！";

        }


        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/UploadAndDownload/uploadHomework.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
