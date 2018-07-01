package com.servlet.project.bean;

public class StudentBean {
	int fee;
	int paid;
	int due;
	int id;
	String name;
	String email;
	String gender;
	String course;
	String address;
	String contact;
	
	public StudentBean(int id2, String name2, String email2, String gender2, String contact2, String address2, String course2, int fee2, int paid2, int due2) {
		this.id=id2;
		this.name=name2;
		this.email=email2;
		this.gender=gender2;
		this.course=course2;
		this.address=address2;		
		this.contact=contact2;
		this.fee=fee2;
		this.paid=paid2;
		this.due=due2;
	}	
	

	
	public StudentBean(String name2, String email2, String gender2, String contact2, String address2, String course2, int fee2, int paid2, int due2) {
		
		this.name=name2;
		this.email=email2;
		this.gender=gender2;
		this.course=course2;
		this.address=address2;		
		this.contact=contact2;
		this.fee=fee2;
		this.paid=paid2;
		this.due=due2;
	}
         
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}



	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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
