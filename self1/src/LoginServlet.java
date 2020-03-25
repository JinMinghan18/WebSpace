import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter cout=response.getWriter();
        boolean is=false;
        String path = "D:\\idea\\self1\\userinfo.txt";
        String user=request.getParameter("mid");
        String password=request.getParameter("password");
        password=Sha256.getSHA256(password);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line=null;
        while((line=br.readLine())!=null) {
            int pos=line.indexOf("|");
            String u=line.substring(0, pos);
            String p=line.substring(pos+1);
            p=p.substring(0,p.indexOf("|"));
            if(u.equals(user)&&p.equals(password))
            {
                is=true;
                response.sendRedirect("welcome.html");
                break;
            }
        }
        if(!is) response.sendRedirect("failed.html");
    }
}