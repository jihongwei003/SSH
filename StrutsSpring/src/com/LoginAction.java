package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	// 基于model的驱动
	private User user = new User();
	
	public String login() throws Exception {
		ActionContext ac = ActionContext.getContext();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// aspectBusiness代理bean是由Spring自动生成的
		ActionInter business = (ActionInter) context
				.getBean("aspectBusiness");

		System.out.println("username:"+ user.getUsername());
		
		if (business.login(user)) {
			ac.put("success", "登录成功");
			return "success";
		} else {
			ac.put("error", "登录失败");
			return "error";
		}
	}

	public String register() {
		ActionContext.getContext().put("message", "注册成功");
		return "success";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
