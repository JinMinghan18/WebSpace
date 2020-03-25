import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login.do",urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet(){super();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean isright = false;
        String path = "D:\\MyStudySpace\\WebSpace\\web_apply\\web_apply_ex2\\userinfo.txt";
        String username = request.getParameter("myid");
        String password = request.getParameter("password");
        password = Sha256.getSHA256(password);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str = null;
        while ((str=br.readLine())!=null){
            int position = str.indexOf("|");
            String user = str.substring(0,position);//账号
            String pass = str.substring(position+1);
            pass = pass.substring(0,pass.indexOf("|"));//密码
            if(user.equals(username)&& pass.equals(password)){
                isright=true;
                response.sendRedirect("ex2_3welcome.html");
                break;
            }
        }
        if(!isright) response.sendRedirect("login_failed.html");
    }
}
