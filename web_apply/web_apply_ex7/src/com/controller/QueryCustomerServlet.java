package com.controller;

import com.dao.CustomerDao;
import com.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/queryCustomer.do"})
public class QueryCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cname = request.getParameter("cname");
        CustomerDao dao = new CustomerDao();
        Customer customer = dao.findByName(cname);
        request.setAttribute("customer",customer);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/showCustomer.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
