import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@WebServlet("/parsejson.do")
@MultipartConfig(location="D:\\MyStudySpace\\WebSpace\\web_apply\\others\\ex2",fileSizeThreshold=1024*100)
public class ParseJsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("upload");
        response.setContentType("text/html;charset=UTF-8");
        StringBuffer str=new StringBuffer(2*1024*1024);
        try {
            InputStream inputStream = part.getInputStream();
            BufferedReader br = new     BufferedReader(new InputStreamReader(inputStream));

            String line="";
            while ((line = br.readLine()) != null) {
                str.append(line.trim());  //new String(str,"UTF-8")
            }
            br.close();
        }
        catch(IOException e) {
            e.getStackTrace();
        }

        PrintWriter cout=response.getWriter();
        JSONArray objects=JSON.parseArray(str.toString());
        cout.print("<html><head><script type=\"text/javascript\"> "+
                " function test(){ document.getElementById(\"tableInfo\").value=document.getElementById(\"table\").innerHTML; }"+
                "</script></head><body>");
        cout.print("<form action=\"exportExcel\" method=\"post\" ><div align='center'><table border='1'  id=\"table\">");
        cout.print("<h1>学生成绩列表</h1>");
        cout.print("<tr align='center'><th>序号</th><th>学号</th><th>姓名</th><th>课程名</th><th>成绩</th></tr>");
        for(int i=0;i<objects.size();i++)
        {
            JSONObject obj =(JSONObject) objects.get(i);
            cout.print("<tr align='center'>");
            cout.print("<td>"+(i+1)+"<input name=\"isclick\" type=\"checkbox\" value="+(i+1)+" />"+"</td>");
            cout.print("<td>"+obj.getString("stuid")+"</td>");
            cout.print("<td>"+obj.getString("name")+"</td>");
            cout.print("<td>"+obj.getString("courseName")+"</td>");
            cout.print("<td>"+obj.getString("score")+"</td>");
            cout.print("</tr>");
        }
        cout.print("</table></div><br><br><div align='center'><input type='submit' name=\"excel\" value=\" 导出表格 \" onclick=\"test()\"/>");
        cout.print("<input type=\"hidden\" id=\"tableInfo\" name=\"tableInfo\" value=\"\"/></div>");

        cout.print("</form></body></html>");
    }
}
