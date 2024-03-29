package com.demo;

import com.model.Sha256;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet({"/RegisterStudent"})
public class RegisterStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String idnumber = request.getParameter("idnumber");
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        password = Sha256.getSHA256(password);
        String college = request.getParameter("college");
        String major=request.getParameter("major");
        String class1=request.getParameter("class1");
        int line = 0;
        String sql;
        boolean isfind=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/school_info?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai", "root", "123456");
            Statement st = conn.createStatement();
            st.setMaxRows(20);
            sql = "select * from dbt_student";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(number.equals(rs.getString("number"))||number.equals(rs.getString("idnumber")))
                    isfind = true;
            }
            if(!isfind){
                sql = "INSERT INTO dbt_student values('"+name+"','"+idnumber+"','"+number+"','"+password+"','"+college+"','"+major+"','"+class1+"');";
                line = st.executeUpdate(sql);
            }
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }catch (SQLException e2){
            e2.printStackTrace();
        }
        System.out.println("影响"+line+"行");
        if(isfind)
        {
            RequestDispatcher rd = request.getRequestDispatcher("failed.jsp");
            rd.forward(request,response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
