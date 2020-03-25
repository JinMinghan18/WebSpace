import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.Buffer;

@WebServlet(name = "/toExcel.do",urlPatterns = {"/toExcel.do"})
public class toExcel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public boolean isexist(String []a,int p){
        for(int i=0;i<a.length;i++)
            if(p==Integer.parseInt(a[i])) return true;
        return false;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Encoding","GBK");
        response.setHeader("Content-Disposition","attachment; filename="+java.net.URLEncoder.encode("学生成绩.xls","UTF-8"));
        response.setContentType("application/vnd.ms-excel;charset=GBK");

        PrintWriter out = response.getWriter();
        out.println("cno\tid\tname\tcourseName\tscore");
        File file = new File("D:\\stu.txt");
        int cnt = 5;
        String str = "";
        try{
            BufferedReader br = new BufferedReader(new
                    FileReader("D:\\stu.txt"));
            while((str = br.readLine())!=null){
                System.out.println(str);
                String s[] = str.split(" ");
                for(int i = 0;i<s.length;i++){
                    out.print(s[i]+"\t");
                }
                out.println("");
            }
            br.close();
        }catch (IOException r){}

    }
}
