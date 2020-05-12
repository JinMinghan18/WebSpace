package control;

import model.Book;
import sun.security.util.Length;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

@WebServlet({"/SelectBook"})
public class SelectBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String keys = request.getParameter("keys");
        String path = this.getServletContext().getRealPath("/WEB-INF/book.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
        Vector<Book> selected = new Vector<>();
        while(br.ready()){
            String[] str = br.readLine().split("，");
            for(int i = 0; i<str.length;i++){
                if(str[i].indexOf(keys) != -1){
                    selected.add(new Book(str[0],str[1],str[2],str[3],str[4],str[5]));
                    break;
                }
            }
        }
        request.setAttribute("selected",selected);
        request.getRequestDispatcher("/display.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
