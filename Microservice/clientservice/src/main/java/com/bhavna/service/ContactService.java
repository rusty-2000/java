package com.bhavna.service;

import java.util.List;

import com.bhavna.entity.Contact;

public interface ContactService {
	public List<Contact> getContacts(int userId);
}
