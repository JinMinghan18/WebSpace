package stu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    public StudentServlet(){}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name= request.getParameter("name");
        String stuId = request.getParameter("stuId");
        String major = request.getParameter("major");
        Student student = new Student(stuId,name,major);

        HttpSession session = request.getSession();
        synchronized (session){
            session.setAttribute("student",student);
        }
        RequestDispatcher rd =request.getRequestDispatcher("/JSP/displayStudent.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
