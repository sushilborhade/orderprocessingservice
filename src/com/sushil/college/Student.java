package com.sushil.college;

public class Student {

	String firstName;
	String lastName;
	String address;
	int age;
	public String getFirstName() {
		//My business logic
//		return firstName;
		throw new IllegalArgumentException("Method not supported.");
	}
	public void setFirstName(String firstName) {
		throw new IllegalArgumentException("Method not supported.");
	}
	public String getLastName() {
		throw new IllegalArgumentException("Method not supported.");
	}
	public void setLastName(String lastName) {
		throw new IllegalArgumentException("Method not supported.");
	}
	public String getAddress() {
		throw new IllegalArgumentException("Method not supported.");
	}
	public void setAddress(String address) {
		throw new IllegalArgumentException("Method not supported.");
	}
	public int getAge() {
		throw new IllegalArgumentException("Method not supported.");
	}
	public void setAge(int age) {
		throw new IllegalArgumentException("Method not supported.");
	}
}
