package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bhavna.entity.User;
import com.bhavna.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		// return this.userService.getUser(userId);
		User user = this.userService.getUser(userId);
		List contacts = this.restTemplate.getForObject("http://localhost:8082/contact/user/" + user.getUserId(),List.class);
		user.setContact(contacts);
		return user;
	}
}
