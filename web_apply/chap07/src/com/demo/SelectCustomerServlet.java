package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.CustomerDao;
import com.model.Customer;

@WebServlet("/SelectCustomerServlet")
public class SelectCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao dao = new CustomerDao();
        Customer customer = null;
		String cname = request.getParameter("custName");
		customer= dao.findByName(cname);
	    request.setAttribute("customer", customer);
	    RequestDispatcher rd = request.getRequestDispatcher("/displayCustomer.jsp");
	    rd.forward (request,response);
        return;
	}
}
