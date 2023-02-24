package com.bhavna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhavna.entity.User;

@Service
public class UserServiceImpl implements UserService {

	List<User> list = List.of(new User(1001, "Anil kumar", "976854733"), new User(1002, "Raju Sharma", "765849320"),
			new User(1003, "vaishnavi gupta", "879650432"), new User(1004, "ramesh singh", "645899921"));

	@Override
	public User getUser(int id) {

		return this.list.stream().filter(user -> user.getUserId() == id).findAny().orElse(null);
	}

}
