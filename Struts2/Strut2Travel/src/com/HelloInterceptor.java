package com;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class HelloInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("拦截器开始运行");
		String resultString = invocation.invoke();
		System.out.println("拦截器结束");

		return resultString;
	}

}
