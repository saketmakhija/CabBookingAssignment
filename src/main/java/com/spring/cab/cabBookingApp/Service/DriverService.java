package com.spring.cab.cabBookingApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.cab.cabBookingApp.Entity.Driver;

@Service
public class DriverService {

	public List<Driver> driverList=null;
	
	public DriverService() {
		driverList=new ArrayList<>();
	}
	
	public List<Driver> addDriverToList(Driver driver){
		driverList.add(driver);
		return driverList;
	}
	

	public Driver updateDriverLocation(String name, int x_coor, int y_coor) {
		driverList=driverList.stream().map(d->{
			if(d.getName().equalsIgnoreCase(name)){
				d.setX(x_coor);
				d.setY(y_coor);
			}
			return d;
		}).collect(Collectors.toList());
		return (Driver)driverList.stream().filter(d->d.getName().equalsIgnoreCase(name)).findFirst().get();	
	}

	public Driver updateDriverStatus(String name, boolean status) {
		driverList=driverList.stream().map(d->{
			if(d.getName().equalsIgnoreCase(name)){
				d.setStatus(status);
			}
			return d;
		}).collect(Collectors.toList());
		return (Driver)driverList.stream().filter(d->d.getName().equalsIgnoreCase(name)).findFirst().get();
	}
}
