package com.demo;

import com.model.Sha256;
import jdk.nashorn.internal.runtime.RewriteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet({"/Login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("a1");
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        String password2 = Sha256.getSHA256(password);
        String sql;
        boolean isfind = false;
        HttpSession session = request.getSession();

        if(type.equals("student"))
        {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/school_info?serverTimezone=GMT%2B8","root","123456"
                );
                Statement st = con.createStatement();
                sql = "SELECT * FROM  dbt_student";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    if(number.equals(rs.getString("number"))&&password2.equals(rs.getString("password")))
                    {
                        isfind=true;
                        session.setAttribute("name",rs.getString("name"));
                        session.setAttribute("idnumber",rs.getString("idnumber"));
                        session.setAttribute("number",number);
                        session.setAttribute("password",password2);
                        session.setAttribute("college",rs.getString("college"));
                        session.setAttribute("major",rs.getString("major"));
                        session.setAttribute("class1",rs.getString("class1"));
                    }
                }
            }catch (ClassNotFoundException e1){
                e1.printStackTrace();
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
            if(isfind)
            {
                RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
                rd.forward(request,response);
            }
        }
        else {//教师
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/school_info?serverTimezone=GMT%2B8","root","123456"
                );
                Statement st = con.createStatement();
                sql = "SELECT * FROM dbt_teacher";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    if(number.equals(rs.getString("number"))&&password2.equals(rs.getString("password")))
                    {
                        isfind=true;
                        session.setAttribute("name", rs.getString("name"));
                        session.setAttribute("idnumber", rs.getString("idnumber"));
                        session.setAttribute("number", number);
                        session.setAttribute("password", password2);
                        session.setAttribute("college", rs.getString("college"));
                        session.setAttribute("role", rs.getString("role"));
                    }
                }
            }catch (ClassNotFoundException e1){
                e1.printStackTrace();
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
            if(isfind)
            {
                RequestDispatcher rd = request.getRequestDispatcher("teacher.jsp");
                rd.forward(request,response);
            }
        }
        if(!isfind){
            RequestDispatcher rd = request.getRequestDispatcher("error2.jsp");
            rd.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
