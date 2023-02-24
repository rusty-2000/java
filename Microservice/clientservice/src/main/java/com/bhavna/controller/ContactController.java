package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.Contact;
import com.bhavna.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
	@GetMapping("/user/{userId}")
	public List<Contact> getAllContacts(@PathVariable("userId") int userId){
		return this.contactservice.getContacts(userId);
	}

}
