package action;

import org.easymock.EasyMock;
import org.junit.Test;
import service.UserService;

import java.util.Iterator;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;

public class RegisterActionTest {

    private RegisterAction registerAction;
    private UserService userService;
    private String username = "";
    private String password = "";

    @Test
    public void validateTestForEmptyUsername() {
        registerAction = new RegisterAction();
        username = "";
        password = "pwd";
        registerAction.setUsername(username);
        registerAction.setPassword(password);
        registerAction.validate();
        Iterator<String> iterator = registerAction.getActionErrors().iterator();
        assertEquals("用户名不能为空！",iterator.next());
    }
    @Test
    public void validateTestForEmptyPwd() {
        registerAction = new RegisterAction();
        username = "test";
        password = "";
        registerAction.setUsername(username);
        registerAction.setPassword(password);
        registerAction.validate();
        Iterator<String> iterator = registerAction.getActionErrors().iterator();
        assertEquals("密码不能为空！",iterator.next());
    }
    @Test
    public void validateTestForEmptyAll() {
        registerAction = new RegisterAction();
        username = "";
        password = "";
        registerAction.setUsername(username);
        registerAction.setPassword(password);
        registerAction.validate();
        Iterator<String> iterator = registerAction.getActionErrors().iterator();
        assertEquals("用户名不能为空！",iterator.next());
        assertEquals("密码不能为空！",iterator.next());
    }
    @Test
    public void validateTestForCorrect() {
        registerAction = new RegisterAction();
        username = "test";
        password = "pwd";
        registerAction.setUsername(username);
        registerAction.setPassword(password);
        registerAction.validate();
        Iterator<String> iterator = registerAction.getActionErrors().iterator();
        assertFalse(iterator.hasNext());
    }
    @Test
    public void executeTestForSuccess() {
        registerAction = new RegisterAction();
        userService = EasyMock.createMock(UserService.class);

        registerAction.setPassword(password);
        registerAction.setUsername(username);
        registerAction.setUserService(userService);

        EasyMock.expect(userService.userRegister(username,password)).andReturn(TRUE);
        EasyMock.replay(userService);

        assertEquals("success",registerAction.execute());
        Iterator<String> Messages = registerAction.getActionMessages().iterator();
        Iterator<String> Errors = registerAction.getActionErrors().iterator();

        assertEquals("注册成功！",Messages.next());
        assertFalse(Errors.hasNext());
        EasyMock.verify(userService);

    }
    @Test
    public void executeTestForFail() {
        registerAction = new RegisterAction();
        userService = EasyMock.createMock(UserService.class);

        registerAction.setPassword(password);
        registerAction.setUsername(username);
        registerAction.setUserService(userService);

        EasyMock.expect(userService.userRegister(username,password)).andReturn(FALSE);
        EasyMock.replay(userService);

        assertEquals("success",registerAction.execute());
        Iterator<String> Messages = registerAction.getActionMessages().iterator();
        Iterator<String> Errors = registerAction.getActionErrors().iterator();

        assertEquals("注册失败,该用户名已存在！",Errors.next());
        assertFalse(Messages.hasNext());
        EasyMock.verify(userService);

    }
}
