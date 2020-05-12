package bank.com.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet({"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean isRight = false;
        String path = "D:\\MyStudySpace\\WebSpace\\web_apply\\web_apply_ex3\\userInfo.txt";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = Sha256.getSHA256(password);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str1 = null;
        str1=br.readLine();
        while(str1!=null){
            int position = str1.indexOf("|");
            String Email = str1.substring(0,position);//账号
            String pass = str1.substring(position+1);
            pass = pass.substring(0,pass.indexOf("|"));//密码
            if(Email.equals(email) && pass.equals(password)){
                isRight = true;
                response.sendRedirect("bank/welcome.jsp");
                break;
            }
            str1=br.readLine();
        }
        if(!isRight) response.sendRedirect("bank/failed.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}