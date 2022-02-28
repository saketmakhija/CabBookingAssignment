package com.spring.cab.cabBookingApp.Entity;

public class Driver {

	private String name;
	private String gender;
	private int age;
	private int x;
	private int y;
	private String carDetail;
	private boolean status;
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Driver(String name, String gender, int age, int x, int y, String carDetail) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.x = x;
		this.y = y;
		this.carDetail = carDetail;
		this.status = true;
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getCarDetail() {
		return carDetail;
	}
	public void setCarDetail(String carDetail) {
		this.carDetail = carDetail;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
