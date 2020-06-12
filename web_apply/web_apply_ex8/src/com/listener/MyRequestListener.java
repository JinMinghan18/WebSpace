package com.listener;

import com.dao.VisiterDao;
import com.model.IP;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class MyRequestListener
                        implements ServletContextListener, ServletRequestListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private int count = 0;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request =
                (HttpServletRequest)sre.getServletRequest();
        if(request.getRequestURI().endsWith("onlineCount.jsp")){
            VisiterDao dao = new VisiterDao();
            IP ip1 = new IP();
            boolean isExist = true;
            isExist = dao.isIPexist(request.getRemoteHost());
            if(!isExist){
                count++;
                sre.getServletContext().setAttribute("count",new Integer(count));
                String IP = request.getRemoteHost();
                String time = null;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                time = df.format(new Date());
                boolean is = dao.addnewIP(IP,time);
            }
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    // Public constructor is required by servlet spec
    public MyRequestListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
