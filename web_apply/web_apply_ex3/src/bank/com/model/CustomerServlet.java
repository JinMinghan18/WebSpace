package bank.com.model;

import sun.security.util.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.ref.ReferenceQueue;
import java.nio.file.Path;
import java.sql.PseudoColumnUsage;

@WebServlet({"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {
    public CustomerServlet(){}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "D:\\MyStudySpace\\WebSpace\\web_apply\\web_apply_ex3\\userInfo.txt";
        boolean isExist = false;

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String custName = request.getParameter("custName");
        String phone = request.getParameter("phone");
        password = Sha256.getSHA256(password);

        System.out.println(custName);

        BufferedReader br = new BufferedReader(new FileReader(path));
        String str = null;
        while((str = br.readLine())!=null){
            str = str.substring(0,str.indexOf("|"));
            if(str.equals(email)){
                isExist = true;
                out.println("<script language='javascript'>alert('注册邮箱已存在')</script>");
                out.println("<center><a href=\"bank/inputCustomer.jsp\">重新输入</a></center>");
                break;
            }
        }
        if(!isExist){
            FileWriter fw = new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(fw);
            String tmp = email+"|"+password+"|"+custName+"|"+phone;
            bw.write(tmp);
            bw.newLine();
            bw.flush();
            bw.close();
            out.println("<center><a href=\"bank/inputCustomer.jsp\">继续输入</a></center>");
        }

        Customer customer = new Customer(email,custName,phone);
        HttpSession session = request.getSession();
        synchronized (session){
            session.setAttribute("customer",customer);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/bank/displayCustomer.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
