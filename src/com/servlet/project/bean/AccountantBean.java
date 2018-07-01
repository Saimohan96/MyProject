package com.servlet.project.bean;

import java.io.Serializable;

public class AccountantBean implements Serializable{
	int id;
	String name;
	String password;
	String email;
	String address;
	String contact;
	public AccountantBean() {
		      //
		}
	
	public AccountantBean(int id2, String name2, String pass, String email2, String no, String address2) {
		// TODO Auto-generated constructor stub
		this.id=id2;
		this.name=name2;
		this.password=pass;
		this.email=email2;
		this.address=address2;
		this.contact=no;
	}

	
	public AccountantBean(String name2, String pass, String email2, String no, String address2) {
		this.name=name2;
		this.password=pass;
		this.email=email2;
		this.address=address2;
		this.contact=no;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
