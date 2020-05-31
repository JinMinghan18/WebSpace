package com.controller;

import com.dao.CustomerDao;
import com.model.Customer;
import sun.plugin2.message.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/deleteCustomer.do"})
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CustomerDao dao = new CustomerDao();
        String message = null;
        try{
            String cust_id = request.getParameter("cust_id");
            boolean success = dao.deleteCustomer(cust_id);
            if (success) {
                message = "<li>删除成功！</li>";
            } else {
                message = "<li>删除失败</li>";
            }
        }catch (Exception e) {
            message = "<li>出现异常</li>";
        }
        request.setAttribute("result",message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAllCustomer.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
