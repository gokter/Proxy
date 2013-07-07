package com.flyingh.user.service;

import java.util.List;

import com.flyingh.service.Service;
import com.flyingh.vo.User;

public interface UserService extends Service {
	void add(User user);

	void update(User user);

	void delete(int id);

	User get(int id);

	List<User> getAll();
}
