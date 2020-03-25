import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Objects;

@WebServlet(name = "/parseJson.do",urlPatterns = {"/parseJson.do"})
@MultipartConfig(location = "D:\\MyStudySpace\\WebSpace\\web_apply\\others\\ex2",fileSizeThreshold = 1024)
public class parseJson extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("upload");
        response.setContentType("text/html;charset=UTF-8");
        StringBuffer sb = new StringBuffer(1024*1024);
        try{
            InputStream inS = part.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inS));
            String line = "";
            while((line = br.readLine()) != null){
                sb.append(line.trim());
            }
            br.close();

        } catch(IOException e){
            e.getStackTrace();
        }

        PrintWriter out = response.getWriter();
        JSONArray obj = JSON.parseArray(sb.toString());
        out.print("<html><head><script type=\"text/javascript\">"+
                "function test(){ document.getElementById(\"tableInfo\").value=document.getElementBy(\"table\").innerHTML; }"+
                "</script></head><body>");
        out.print("<form action=\"toExcel.do\" method=\"post\"><div align='center'><table border='1' id=\"table\">");
        out.print("<h3>students'score</h3>");
        out.print("<tr align='center'><th>cno</th><th>id</th><th>name</th><th>course</th><th>score</th></tr>");
        Writer writer = null;
        writer = new FileWriter("D:\\stu.txt",true);
        for(int i = 0;i<obj.size();i++){
            JSONObject objects = (JSONObject) obj.get(i);
            writer.write(i+1+" ");
            writer.write(objects.getString("stuid")+" ");
            writer.write(objects.getString("name")+" ");
            writer.write(objects.getString("courseName")+" ");
            writer.write(objects.getString("score")+" \n");

            out.print("<tr align='center'>");
            out.print("<td>"+(i+1)+"<input name=\"isclick\" type=\"checkbox\" value="+(i+1)+" />"+"</td>");
            out.print("<td>"+objects.getString("stuid")+"</td>");
            out.print("<td>"+objects.getString("name")+"</td>");
            out.print("<td>"+objects.getString("courseName")+"</td>");
            out.print("<td>"+objects.getString("score")+"</td>");
            out.print("</tr>");
        }
        writer.flush();
        writer.close();
        out.print("</table></div><br><br><div align='center'><input type='submit' name=\"excel\" value=\"转换为Excel\" onclick=\"test()\"/>");
        out.print("<input type=\"hidden\" id=\"tableInfo\" name=\"tableInfo\" value=\"\"/></div> ");
        out.print("</form></body></html>");
    }
}
