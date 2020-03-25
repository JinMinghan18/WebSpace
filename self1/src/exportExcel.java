import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/exportExcel")
public class exportExcel extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public exportExcel() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public boolean isexist(String []a,int p)
    {
        for(int i=0;i<a.length;i++)
            if(p==Integer.parseInt(a[i])) return true;
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Encoding", "gb2312");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + java.net.URLEncoder.encode("学生成绩.xls", "UTF-8"));
        response.setContentType("application/vnd.ms-excel;charset=gb2312");

        PrintWriter out = response.getWriter();
        out.println("序号\t学号\t姓名\t课程名\t成绩");
        String info=new String(request.getParameter("tableInfo").getBytes("iso-8859-1"), "utf-8");
        String []checkValue=request.getParameterValues("isclick");
        info=info.trim();
        info=info.substring(info.indexOf("<td>"),info.lastIndexOf("</tr>"));
        info=info.replaceAll("<td>", " ");
        info=info.replaceAll("</td>", " ");
        info=info.replaceAll("<tr align=\"center\">", " ");
        info=info.replaceAll("</tr>", " ");
        info=info.replaceAll("<input name=\"isclick\" type=\"checkbox\" value=\"1\">", " ");
        info=info.replaceAll("<input name=\"isclick\" type=\"checkbox\" value=\"2\">", " ");
        info=info.replaceAll("<input name=\"isclick\" type=\"checkbox\" value=\"3\">", " ");
        System.out.print(info);
        for(int i=0;i<checkValue.length;i++) System.out.println(checkValue[i]);
        String s[] = info.split(" ");
        int count=5;
        for (int i = 0; i < s.length; i++) {
            if(s[i].length()>=1)
            {
                if(isexist(checkValue,count/5))
                {
                    out.print(s[i] + "\t");
                    count++;
                    if(count%5==0)
                    {
                        out.println("");
                    }
                }
                else
                {
                    count++;
                }
            }
        }
    }
}
