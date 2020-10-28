package cn.edu.zjut.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class AuthorityInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception{
        System.out.println("Authority Interceptor executed!");
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        String user = (String)session.get("user");
        if(user!=null){
            return invocation.invoke();
        }
        else {
            ctx.put("tip","您还没有登录，请输入用户名密码登录系统");
            return Action.LOGIN;
        }
    }
}
