package com.spring.cab.cabBookingApp.Entity;


public class User {

	
	private String name;
	private String gender;
	private String phone;
	private int age;
	private int x_coordinate;
	private int y_coordinate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}



	public User(String name, String gender, int age, int x_coordinate, int y_coordinate) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getX_coordinate() {
		return x_coordinate;
	}

	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	public int getY_coordinate() {
		return y_coordinate;
	}

	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}
	
	

	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", phone=" + phone + ", age="
				+ age + ", x_coordinate=" + x_coordinate + ", y_coordinate=" + y_coordinate + "]";
	}



	
	
	
	
}
