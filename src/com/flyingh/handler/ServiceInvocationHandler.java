package com.flyingh.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.flyingh.service.Service;

public class ServiceInvocationHandler implements InvocationHandler {
	private Service service;

	public ServiceInvocationHandler(Service service) {
		super();
		this.service = service;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object result = method.invoke(service, args);
		after();
		return result;
	}

	private void after() {
		System.out.println("ServiceInvocationHandler.after()");
	}

	private void before() {
		System.out.println("ServiceInvocationHandler.before()");
	}

}
