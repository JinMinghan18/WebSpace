import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

public class LoginServletTest{
    public LoginServlet servlet;
    public HttpServletRequest request;
    public HttpSession session;

    @BeforeEach
    public void init(){
        servlet = new LoginServlet();
        request = EasyMock.createStrictMock(HttpServletRequest.class);
        session = EasyMock.createStrictMock(HttpSession.class);
    }

    @Test
    public void testLoginFailed() throws Exception{
        expect(request.getParameter("username")).andReturn(null);
        expect(request.getParameter("password")).andReturn(null);
        replay(request);
        try {
            servlet.doPost(request,null);
            fail("Not caught exception!");
        }catch (RuntimeException re){
            assertEquals("Login failed.",re.getMessage());
        }
        verify(request);

    }
    @Test
    public void testLoginSuccess() throws Exception{
        HttpServletRequest request = createMock(HttpServletRequest.class);
        final ServletContext contextObj = createMock(ServletContext.class);
        RequestDispatcher dispatcherObj = createMock(RequestDispatcher.class);

        expect(request.getParameter("username")).andReturn("admin");
        expect(request.getParameter("password")).andReturn("123456");
        expect(contextObj.getNamedDispatcher("dispatcher")).andReturn(dispatcherObj);
        dispatcherObj.forward(request,null);

        replay(request);
        replay(contextObj);
        replay(dispatcherObj);

        LoginServlet servlet = new LoginServlet(){
            private  static final long serialVersionUID = 1L;
            public ServletContext getServletContext(){
                return contextObj;
            }
        };
        servlet.doPost(request,null);

        verify(request);
        verify(contextObj);
        verify(dispatcherObj);

    }
}
