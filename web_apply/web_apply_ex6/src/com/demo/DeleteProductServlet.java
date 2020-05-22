package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet({"/DeleteProduct"})
public class DeleteProductServlet extends HttpServlet {
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
        String id = request.getParameter("id");
        try{
            String sql="DELETE FROM products WHERE id = ?";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,id);
            int n = pstmt.executeUpdate();
            if(n!=0){
                request.getRequestDispatcher("test.jsp").forward(request,response);
            }else{
                response.sendRedirect("error.jsp");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
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
