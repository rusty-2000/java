package com.bhavna.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bhavna.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	List<Contact> list = List.of(new Contact(51L, "priti@gmail.com", 1001, "anil"),
			new Contact(52L, "himanshu@gmail.com", 1002, "himanshu"),
			new Contact(53L, "rohit@gmail.com", 1003, "rohit"), new Contact(54L, "shreya@gmail.com", 1002, "shreya"),
			new Contact(55L, "pankaj@gmail.com", 1003, "pankaj")

	);

	@Override
	public List<Contact> getContacts(int userId) {
		// TODO Auto-generated method stub
		return this.list.stream().filter(contact -> contact.getUserId() == userId).collect(Collectors.toList());
	}

}
