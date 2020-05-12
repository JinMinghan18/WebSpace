package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="ExcelServlet",urlPatterns={"/excel.do"})
public class ExcelServlet extends HttpServlet{
   public void doGet(HttpServletRequest request, 
HttpServletResponse response)
                      throws ServletException, IOException{
// 设置响应的内容类型
response.setContentType("application/vnd.ms-excel;charset=gb2312");
    PrintWriter out = response.getWriter();
   
    out.println("学号\t姓名\t性别\t年龄\t所在系");
    out.println("95001\t李勇\t男\t20\t信息");
    out.println("95002\t刘晨\t女\t19\t数学");
  }
}

