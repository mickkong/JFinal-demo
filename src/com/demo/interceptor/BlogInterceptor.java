package com.demo.interceptor;

import com.demo.common.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * BlogInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public class BlogInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		inv.invoke();
		User user = inv.getController().getSessionAttr("user");
		if(user != null) {
			inv.getController().setSessionAttr("user", user);
		} else {
			inv.getController().redirect("/");
		}
	}
}
