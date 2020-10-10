package cn.edu.zjut;

import cn.edu.zjut.model.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/login"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        if(checkUser(user)){
            request.setAttribute("USER",user);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/loginSuccess.jsp");
            rd.forward(request,response);
        }else{
            response.sendRedirect("/javaweb_prj1_war_exploded/JSP/loginFailed.jsp");
        }
    }

    boolean checkUser(UserBean user){
        if("zjut".equals(user.getUsername()) && "zjut".equals(user.getPassword())) {
            return true;
        }else{
            return false;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
