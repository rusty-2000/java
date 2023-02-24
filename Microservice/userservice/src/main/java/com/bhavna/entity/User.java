package com.bhavna.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String name;
	private String phone;
	List<Contact> contact = new ArrayList<>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public User(int userId, String name, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", contact=" + contact + "]";
	}
	

}
