import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public RegisterServlet() {
            super();
        }
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doGet(request, response);
        }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter cout = response.getWriter();
            String path = "D:\\idea\\self1\\userinfo.txt";

            boolean isexist = false;

            String user = request.getParameter("mid");
            String password = request.getParameter("password");
            String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
            String mname = new String(request.getParameter("mname").getBytes("iso-8859-1"), "utf-8");
            String emil = request.getParameter("emil");
            String phone = request.getParameter("phone");
            password = Sha256.getSHA256(password);

            System.out.println(user);

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.substring(0, line.indexOf("|"));
                if (line.equals(user)) {
                    isexist = true;
                    cout.println("<script language='javascript'>alert('用户名已经存在,请重新输入')</script>");
                    cout.println("<center><a href=\"register.html\">重新注册</a></center>");
                    break;
                }
            }
            if (!isexist) {
                FileWriter fw = new FileWriter(path, true);
                BufferedWriter bw = new BufferedWriter(fw);
                String temp = user + "|" + password + "|" + mname + "|" + sex + "|" + emil + "|" + phone;
                bw.write(temp);
                bw.newLine();
                bw.flush();
                bw.close();
                cout.println("<center>注册成功,返回<a href=\"login.html\">登录</a></center>");
            }
        }
}
