package service;

import dao.UserDao;
import entity.User;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private User user;
    private UserDao dao;
    private UserService service;
    private HibernateTemplate hibernateTemplate;

    static String username = "test";
    static String password = "pwd";
    @Before
    public void init(){
        dao = EasyMock.createMock(UserDao.class);
        service = new UserService();
    }

    @Test
    public void loginVerifyTest() {
        EasyMock.expect(dao.verifyUsername(username)).andReturn(true);
        EasyMock.expect(dao.verifyPassword(username,password)).andReturn(true);
        EasyMock.replay(dao);
        service.setUserDao(dao);
        boolean verify = service.loginVerify(username, password);
        assertTrue(verify);
    }
    @Before
    public void init2(){
        dao = new UserDao();
        service = new UserService();
        hibernateTemplate = EasyMock.createMock(HibernateTemplate.class);
    }
    @Test
    public void userRegister() {
        String sql = "from User where username=?";
        List<User> tmp = new LinkedList<>();
        EasyMock.expect((List<User>)hibernateTemplate.find(sql,username)).andReturn(tmp);
        EasyMock.expect(hibernateTemplate.save(EasyMock.<User>anyObject())).andReturn(1);
        EasyMock.replay(hibernateTemplate);
        dao.setHibernateTemplate(hibernateTemplate);
        service.setUserDao(dao);

        boolean register = service.userRegister(username, password);
        assertFalse(register);

    }
}
