package com.spring.cab.cabBookingApp.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cab.cabBookingApp.Entity.Driver;

@Service
public class BookingService {
	
	@Autowired
	private DriverService driverService;

	public List<Driver> findDrivers(int x, int y){
		
		List<Driver> driverList = driverService.driverList;
		
		List<Driver> drivers = driverList.stream().map(d->{
			
			int x_dis=Math.abs(d.getX()-x);
			int y_dis=Math.abs(d.getY()-y);
			x_dis=x_dis*x_dis;
			y_dis=y_dis*y_dis;
			double dis = Math.sqrt(x_dis+y_dis);
			int distance = (int)dis;
			if(distance<=5) {
				return d;
			}
			return null;	
		}).collect(Collectors.toList());
		
		return drivers;
	}
	
}
