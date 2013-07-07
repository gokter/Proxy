package com.flyingh.user.service.impl;

import java.util.List;

import com.flyingh.user.service.UserService;
import com.flyingh.vo.User;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User user) {
		System.out.println("UserServiceImpl.add()");
	}

	@Override
	public void update(User user) {
		System.out.println("UserServiceImpl.update()");
	}

	@Override
	public void delete(int id) {
		System.out.println("UserServiceImpl.delete()");
	}

	@Override
	public User get(int id) {
		System.out.println("UserServiceImpl.get()");
		return null;
	}

	@Override
	public List<User> getAll() {
		System.out.println("UserServiceImpl.getAll()");
		return null;
	}

}
