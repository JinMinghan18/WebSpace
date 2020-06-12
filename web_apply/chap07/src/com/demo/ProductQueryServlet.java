package com.demo;

import java.io.*;
import java.sql.*;

import javax.sql.DataSource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.model.Product;
import java.util.*;
import javax.naming.*;

@WebServlet("/productquery.do")
public class ProductQueryServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  DataSource dataSource;
	  public void init() {
	    try {
	       Context context = new InitialContext();
	       dataSource = (DataSource)context.lookup("java:comp/env/jdbc/sampleDS");
	    }catch(NamingException ne){
	       log("Exception:"+ne);
	    }
	 }
	 public void doPost(HttpServletRequest request, 
                         HttpServletResponse response) 
                   throws ServletException, IOException {    
	     String productid = request.getParameter("productid");
	     try{
	    	Connection dbconn = dataSource.getConnection();
	    	String sql="SELECT * FROM products WHERE prod_id = ?";
	        PreparedStatement pstmt = dbconn.prepareStatement(sql);
	        pstmt.setString(1,productid);
	        ResultSet rst = pstmt.executeQuery();
	        if(rst.next()){
	           Product product = new Product();
	           product.setProd_id(rst.getString("prod_id"));
	           product.setPname(rst.getString("pname"));
	           product.setPrice(rst.getDouble("price"));
	           product.setStock(rst.getInt("stock"));
	           request.getSession().setAttribute("product", product);
	           response.sendRedirect("/chap07/displayProduct.jsp");
	        }else{
	           response.sendRedirect("/chap07/error.jsp");
	        }	
	      }catch(SQLException e){
	  	      e.printStackTrace();
	      }
}
	 public void doGet(HttpServletRequest request, 
                       HttpServletResponse response) 
                  throws ServletException, IOException {
	     ArrayList<Product> productList = null; 
	     productList = new ArrayList<Product>();
	     String sql="SELECT * FROM products";
	    try{ 
         Connection dbconn = dataSource.getConnection();
         PreparedStatement pstmt = dbconn.prepareStatement(sql);
         ResultSet result = pstmt.executeQuery();
         while(result.next()){
            Product product = new Product();
            product.setProd_id(result.getString("prod_id"));
            product.setPname(result.getString("pname"));
            product.setPrice(result.getDouble("price"));
            product.setStock(result.getInt("stock"));
            productList.add(product);
         }
         if(!productList.isEmpty()){
    	       request.getSession().setAttribute("productList",productList);
            response.sendRedirect("/chap07/displayAllProduct.jsp");
         }else{
            response.sendRedirect("/chap07/error.jsp");
         }
       }catch(SQLException e){
  	      e.printStackTrace();
       }    
   }
}