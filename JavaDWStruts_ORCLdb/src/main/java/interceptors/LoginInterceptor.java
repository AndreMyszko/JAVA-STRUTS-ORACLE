package interceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import action.LoginAction;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("LoginInterceptor - destroy");
	}

	@Override
	public void init() {
		System.out.println("LoginInterceptor - init");
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("LoginInterceptor - pre-processing");
		Object user = ServletActionContext.getRequest().getSession().getAttribute("loggedUser");
		if (user == null) {
			if(ai.getAction().getClass().equals(LoginAction.class)) {
				ai.invoke();
			}
			return "input";				
		} else
		System.out.println("LoginInterceptor - post-processing");
		return ai.invoke();
	}

}
