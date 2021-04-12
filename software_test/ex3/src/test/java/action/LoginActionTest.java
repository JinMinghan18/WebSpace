package action;

import entity.User;
import org.easymock.EasyMock;
import org.junit.Test;
import service.UserService;

import java.util.Iterator;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;

public class LoginActionTest {


    private String username;
    private String password;
    private LoginAction loginAction;
    private UserService userService;

    private Map session;

    @Test
    public void validateTestForEmptyUsername() {
        loginAction = new LoginAction();
        username = "";
        password = "pwd";
        loginAction.setUsername(username);
        loginAction.setPassword(password);
        loginAction.validate();
        Iterator<String> iterator = loginAction.getActionErrors().iterator();
        assertEquals("用户名不能为空！",iterator.next());
    }
    @Test
    public void validateTestForEmptyPwd() {
        loginAction = new LoginAction();
        username = "test";
        password = "";
        loginAction.setUsername(username);
        loginAction.setPassword(password);
        loginAction.validate();
        Iterator<String> iterator = loginAction.getActionErrors().iterator();
        assertEquals("密码不能为空！",iterator.next());
    }
    @Test
    public void validateTestForEmptyAll() {
        loginAction = new LoginAction();
        username = "";
        password = "";
        loginAction.setUsername(username);
        loginAction.setPassword(password);
        loginAction.validate();
        Iterator<String> iterator = loginAction.getActionErrors().iterator();
        assertEquals("用户名不能为空！",iterator.next());
        assertEquals("密码不能为空！",iterator.next());
    }
    @Test
    public void validateTestForCorrect() {
        loginAction = new LoginAction();
        username = "test";
        password = "pwd";
        loginAction.setUsername(username);
        loginAction.setPassword(password);
        loginAction.validate();
        Iterator<String> iterator = loginAction.getActionErrors().iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void executeTestForSuccess(){
        loginAction = new LoginAction();
        session = EasyMock.createMock(Map.class);
        userService = EasyMock.createMock(UserService.class);

        loginAction.setUserService(userService);
        loginAction.setUsername(username);
        loginAction.setPassword(password);
        loginAction.setSession(session);

        EasyMock.expect(userService.loginVerify(username,password)).andReturn(TRUE);
        EasyMock.replay(userService);
        assertEquals("success",loginAction.execute());
        EasyMock.verify(userService);
    }
    @Test
    public void executeTestForFail(){
        loginAction = new LoginAction();
        session = EasyMock.createMock(Map.class);
        userService = EasyMock.createMock(UserService.class);

        loginAction.setUserService(userService);
        loginAction.setUsername(username);
        loginAction.setPassword(password);
        loginAction.setSession(session);

        EasyMock.expect(userService.loginVerify(username,password)).andReturn(FALSE);
        EasyMock.replay(userService);

        assertEquals("input",loginAction.execute());
        Iterator<String> iterator = loginAction.getActionErrors().iterator();
        assertEquals("登录失败！",iterator.next());
        EasyMock.verify(userService);
    }
}
