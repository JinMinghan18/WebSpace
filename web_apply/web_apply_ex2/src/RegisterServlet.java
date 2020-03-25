import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import sun.security.provider.SHA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "Register.do",urlPatterns = {"/Register.do"})
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "D:\\MyStudySpace\\WebSpace\\web_apply\\web_apply_ex2\\userinfo.txt";

        boolean isexist = false;

        String user = request.getParameter("myid");
        String password = request.getParameter("password");
        String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
        String mname = new String(request.getParameter("mname").getBytes("iso-8859-1"), "utf-8");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        password = Sha256.getSHA256(password);

        System.out.println(user);

        BufferedReader br =new BufferedReader((new FileReader(path)));
        String str =null;
        while((str = br.readLine())!=null){
            str = str.substring(0,str.indexOf("|"));
            if(str.equals(user)){
                isexist=true;
                out.println("<script language='javascript'>alert('用户名已存在')</script>");
                out.println("<center><a href=\"ex2_3register.html\">重新注册</a></center>");
                break;
            }
        }
        if(!isexist){
            FileWriter fw = new FileWriter(path,true);
            BufferedWriter bw =  new BufferedWriter(fw);
            String temp = user+"|"+password+"|"+mname+"|"+sex+"|"+email+"|"+phone_number;
            bw.write(temp);
            bw.newLine();
            bw.flush();
            bw.close();
            out.println("<center>注册成功，返回<a href=\"ex2_3login.html\">登录</a></center>");
        }

    }
}
