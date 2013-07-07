package com.flyingh.demo;

import java.lang.reflect.Proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flyingh.handler.ServiceInvocationHandler;
import com.flyingh.user.service.UserService;
import com.flyingh.user.service.impl.UserServiceImpl;
import com.flyingh.vo.User;

public class Demo {
	private User user;
	private UserService proxy;

	@Before
	public void before() {
		user = new User(1, "flyingh", "password");
		proxy = (UserService) Proxy.newProxyInstance(getClass()
				.getClassLoader(), new Class<?>[] { UserService.class },
				new ServiceInvocationHandler(new UserServiceImpl()));
	}

	@Test
	public void test5() {
		proxy.getAll();
	}

	@Test
	public void test4() {
		proxy.get(user.getId());
	}

	@Test
	public void test3() {
		proxy.delete(user.getId());
	}

	@Test
	public void test2() {
		user.setUsername("flycoding");
		proxy.update(user);
	}

	@Test
	public void test() {
		proxy.add(user);
	}

	@After
	public void after() {
		user = null;
	}
}
