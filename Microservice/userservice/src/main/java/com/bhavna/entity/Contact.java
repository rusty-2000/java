package com.bhavna.entity;

public class Contact {
	private Long cId;
	private String emailId;
	private int userId;
	private String cName;

	public Contact(Long cId, String emailId, int userId, String cName) {
		super();
		this.cId = cId;
		this.emailId = emailId;
		this.userId = userId;
		this.cName = cName;
	}

	public Contact() {
		super();
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return cName;
	}

	public void setName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", emailId=" + emailId + ", userId=" + userId + ", name=" + cName + "]";
	}

}
