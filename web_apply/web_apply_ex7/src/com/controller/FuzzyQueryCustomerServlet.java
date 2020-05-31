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
import java.util.ArrayList;

@WebServlet({"/fuzzyqueryCustomer.do"})
public class FuzzyQueryCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cname = request.getParameter("cname");
        CustomerDao dao = new CustomerDao();
        ArrayList<Customer>customer = dao.findByFuzzyName(cname);
        request.setAttribute("customer",customer);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/showFuzzyQueryCustomer.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
