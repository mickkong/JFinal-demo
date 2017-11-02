package com.demo.controller;

import com.demo.common.model.User;
import com.demo.service.UserService;
import com.jfinal.core.Controller;

public class UserController extends Controller {

	public final static String USER_PATH = "/WEB-INF/view/user/";
	private static UserService service = new UserService();

	public void index() {
		render(USER_PATH + "login.jsp");
	}
	
	public void toRegister() {
		render(USER_PATH + "register.jsp");
	}
	
	public void toFindPwd() {
		render(USER_PATH + "findPwd.jsp");
	}

	public void login() {
		String username = getPara("username");
		String password = getPara("password");
		String result = service.login(username, password);
		if (result.equals(UserService.SUCCESS)) {
			setSessionAttr("user", service.findByUsername(username));
			setAttr("msg", "success");
		} else {
			setAttr("msg", result);
		}
		renderJson();
	}

	public void register() {
		String username = getPara("username");
		String password = getPara("password");
		String phone = getPara("phone");
		String email = getPara("email");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		String result = service.register(user);
		if (result.equals(UserService.SUCCESS)) {
			setAttr("msg", "success");
		} else {
			setAttr("msg", result);
		}
		renderJson();
	}

	public void findPwd() {
		String username = getPara("username");
		String password = getPara("password");
		String phone = getPara("phone");
		String email = getPara("email");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		String result = service.findPwd(user);
		if (result.equals(UserService.SUCCESS)) {
			setAttr("msg", "success");
		} else {
			setAttr("msg", result);
		}
		renderJson();
	}
}
