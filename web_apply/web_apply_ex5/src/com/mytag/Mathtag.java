package com.mytag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class Mathtag implements SimpleTag {
    JspContext jspContext = null;
    JspTag parent = null;
    double x = 0;
    public void setJspContent(JspContext jspContent){
        this.jspContext = jspContent;
    }

    @Override
    public void setParent(JspTag parent) {
        this.parent = parent;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.jspContext = jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

    }

    @Override
    public JspTag getParent() {
        return parent;
    }

    public void doTag() throws JspException, IOException{
        JspWriter out = jspContext.getOut();
        x=10;
        double sum = Math.sqrt(x);
        out.println("10的平方根="+sum+"<br>");
        x=100;
        double sum2 = Math.sqrt(x);
        out.println("100的平方根="+sum2+"<br>");
        x=200;
        double sum3 = Math.sqrt(x);
        out.println("200的平方根="+sum3+"<br>");

    }
}
