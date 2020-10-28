package cn.edu.zjut.action;

//import cn.edu.zjut.bean.ShoppingCart;
import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class UserAction extends ActionSupport {

    private static Integer count = 0;
    public UserAction(){
        System.out.println("创建了一个UserAction类对象");
    }
    public Integer getCount(){
        return count;
    }


    private UserBean loginUser;
    private UserBean regUser;

    public UserBean getLoginUser() {
        return loginUser;
    }
    public UserBean getRegUser() {
        return regUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }
    public void setRegUser(UserBean regUser) {
        this.regUser = regUser;
    }

//    private Map request,session,application;
//    public void setRequest(Map<String ,Object>request){
//        this.request=request;
//    }
//    public void setSession(Map<String,Object>session){
//        this.session=session;
//    }
//
//    public void setApplication(Map application) {
//        this.application = application;
//    }

    private Map session;
    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletContext application = ServletActionContext.getServletContext();
//        HttpSession session = request.getSession();

        ActionContext ctx = ActionContext.getContext();
        session = (Map)ctx.getSession();
//        count++;

        //获取ActionContext对象
//        ActionContext ctx = ActionContext.getContext();
        //通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
//        request =(Map) ctx.get("request");
//        session =(Map) ctx.getSession();
//        application = (Map) ctx.getApplication();
        //访问application范围的属性值
        Integer counter = (Integer) application.getAttribute("counter");
//        ShoppingCart shoppingCart = new ShoppingCart();
//        session.setAttribute("shoppingcart",shoppingCart);
        if(counter==null)
            counter = 1;
        else
            counter+=1;
        //设置application范围的属性
        application.setAttribute("counter",counter);
        UserService userService = new UserService();
        if(userService.login(loginUser)){
            session.put("user",loginUser.getAccount());
            request.setAttribute("tip","您已登录成功");
            return "success";
        }else{
            return "fail";
        }


    }
    public String register(){
        UserService userService = new UserService();
        if(userService.register(regUser)){
            return "success";
        }
        else{

            return "fail";
        }

    }
    public void validateLogin(){
//        UserService userService = new UserService();
        String account = loginUser.getAccount();
        String pwd = loginUser.getPassword();
        if(account == null || account.equals(""))
            this.addFieldError("loginUser.account",this.getText("login.account.null"));
        if(pwd == null || pwd.equals(""))
            this.addFieldError("loginUser.password",this.getText("login.password.null"));
    }
    public void validateRegister(){
        String account = regUser.getAccount();
        String pwd = regUser.getPassword();
        String repwd = regUser.getRepassword();
        String email =  regUser.getEmail();
        String sex = regUser.getSex();
        Date birthdate = regUser.getBirthday();
        if(account == null || account.equals(""))
            this.addFieldError("regUser.account",this.getText("login.account.null"));
        if(pwd == null || pwd.equals(""))
            this.addFieldError("regUser.password",this.getText("login.password.null"));
    }
    public String execute(){
//        UserService userService = new UserService();
//        if(loginUser !=null){
//            if(userService.login(loginUser)){
//                return "success";
//            }
//        }
//        else{
//            if(userService.register(regUser)){
//                return "success";
//            }
//        }


        return "fail";

    }
}
