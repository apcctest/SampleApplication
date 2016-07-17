package com.ntt.cmt.poc.model;

import java.util.Date;

public class User {

	private String firstName;
	private String lastname;
	private String userName;
	private String password;
	private String role;
	private String emailAddress;
	private Date joinedDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastname=" + lastname
				+ ", userName=" + userName + ", password=" + password
				+ ", role=" + role + ", emailAddress=" + emailAddress
				+ ", joinedDate=" + joinedDate + "]";
	}

}
