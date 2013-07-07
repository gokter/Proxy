package com.flyingh.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import org.junit.Before;
import org.junit.Test;

import com.flyingh.callback.UserMethodInterceptor;
import com.flyingh.user.service.UserService;
import com.flyingh.user.service.impl.UserServiceImpl;
import com.flyingh.vo.User;

public class Demo2 {

	private User user;
	private UserService proxy;

	@Before
	public void before() {
		user = new User(1, "flycoding", "password");
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallbackFilter(new CallbackFilter() {

			@Override
			public int accept(Method method) {
				switch (method.getName()) {
				case "add":
				case "update":
				case "delete":
					return 0;
				default:
					return 1;
				}
			}
		});
		enhancer.setCallbacks(new Callback[] { new UserMethodInterceptor(),
				NoOp.INSTANCE });
		proxy = (UserService) enhancer.create();
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
		proxy.update(user);
	}

	@Test
	public void test() {
		proxy.add(user);
	}

}
