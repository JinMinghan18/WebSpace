package com.controller;

import com.dao.CustomerDao;
import com.model.Customer;
import sun.text.resources.uk.JavaTimeSupplementary_uk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/addCustomer.do"})
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao dao = new CustomerDao();
        Customer customer = new Customer();
        String message = null;
        try{
            customer.setCust_id(request.getParameter("cust_id"));
            customer.setCname(new String(request.getParameter("cname").getBytes("iso-8859-1"),"UTF-8"));
            customer.setEmail(new String(request.getParameter("email").getBytes("iso-8859-1"),"UTF-8"));
            customer.setBalance(Double.parseDouble(request.getParameter("balance")));
            boolean success = dao.addCustomer(customer);
            if(success){
                message="<li>添加成功</li>";
            }else {
                message="<li>添加失败</li>";
            }
        }catch (Exception e){
            message = "<li>出现异常</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/addCustomer.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
