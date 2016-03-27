package com.java.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable{
	private String username;
	private String usersex;
	private Integer age;
	private String address;
	private String phoneNumber;

	public Person() {
		super();
	}
	
	public Person(String username, String usersex, Integer age, String address, String phoneNumber) {
		super();
		this.username = username;
		this.usersex = usersex;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person [username=" + username + ", usersex=" + usersex + ", age=" + age + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
}
