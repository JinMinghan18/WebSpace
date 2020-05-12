package com.mytag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

import java.io.*;
import java.security.Key;

public class MarkTag extends SimpleTagSupport {
    private String search = null;
    public void setSearch(String search){
        this.search = search;
    }
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
        String text = "";
        while(br.ready()){
            text += br.readLine();
        }

        text = text.replace(search,"<b><font color='red' size='10'>"+search+"</font></b>");
        out.print(text);
    }
}
