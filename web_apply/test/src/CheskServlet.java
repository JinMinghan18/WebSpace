import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Math.sqrt;

@WebServlet({"/Check_Servlet.do"})
public class CheskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double side_length_1,side_length_2,side_length_3;
        side_length_1 = Double.parseDouble(request.getParameter("side_length_1"));
        side_length_2 = Double.parseDouble(request.getParameter("side_length_2"));
        side_length_3 = Double.parseDouble(request.getParameter("side_length_3"));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        if(side_length_1+side_length_2<=side_length_3||side_length_1+side_length_3<=side_length_2||
                side_length_3+side_length_2<=side_length_1||side_length_1<=0||side_length_2<=0||side_length_3<=0){
            out.println("输入数值不能组成三角形");
        }
        else{
            double p = (side_length_1+side_length_2+side_length_3)/2;
            out.println("三角形面积为"+sqrt(p*(p-side_length_1)*(p-side_length_2)*(p-side_length_3)));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
