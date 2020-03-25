import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TriangleServlet")
public class TriangleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter cout=response.getWriter();
        String a=request.getParameter("aside");
        String b=request.getParameter("bside");
        String c=request.getParameter("cside");
        if(isNumeric(a)&&isNumeric(b)&&isNumeric(c))
        {
            int a1=Integer.parseInt(a);
            int b1=Integer.parseInt(b);
            int c1=Integer.parseInt(c);
            if(a1>0 && b1>0 && c1>0)
            {
                if(a1<(b1+c1) && b1<(a1+c1) && c1<(a1+b1))
                {
                    cout.print("三角形面积=");
                    double p=(a1+b1+c1)/2;
                    double s=Math.sqrt(p*(p-a1)*(p-b1)*(p-c1));
                    cout.println(String.format("%.2f", s));
                }
                else
                {
                    cout.println("三条边长无法构成三角形！");
                }
            }
            else
            {
                cout.println("输入的边长有误！");
            }
        }
        else
        {
            cout.println("输入的边长有误！");
        }
    }
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
