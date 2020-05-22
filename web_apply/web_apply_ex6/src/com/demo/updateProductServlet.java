package com.demo;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet({"/updateProduct"})
public class updateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection dbconn = null;
    public void init(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://127.0.0.1:3306/webstore?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        try{
            Class.forName(driver);
            //创建连接对象
            dbconn = DriverManager.getConnection(dburl,username,password);
        }catch (ClassNotFoundException e1){
            System.out.println(e1);
            getServletContext().log("驱动程序找不到！");
        }catch (SQLException e2){
            System.out.println(e2);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pname = request.getParameter("pname");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        int line = 0;String sql;
        try{
            Statement st = dbconn.createStatement();
            sql = "UPDATE products SET pname='"+pname+"',brand='"+brand+"',price='"+price+"',stock='"+stock+"' WHERE id='"+id+"'";
            line = st.executeUpdate(sql);
        }catch (SQLException e2){
            e2.printStackTrace();
        }
        System.out.println("影响"+line+"行");
        RequestDispatcher rd =
                request.getRequestDispatcher("test.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    public void destroy(){
        try {
            dbconn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
