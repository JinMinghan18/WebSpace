package com.control;

import com.book.JavaBeans;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/BookServlet"})
public class BookServlet extends HttpServlet {
    public BookServlet(){}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bookname= request.getParameter("bookname");
        String bookId = request.getParameter("bookId");
        String author = request.getParameter("author");
        JavaBeans javaBeans = new JavaBeans(bookId,bookname,author);

        HttpSession session = request.getSession();
        synchronized (session){
            session.setAttribute("javaBeans",javaBeans);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/store/displayBook.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
