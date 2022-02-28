package com.spring.cab.cabBookingApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cab.cabBookingApp.Entity.Driver;
import com.spring.cab.cabBookingApp.Entity.User;
import com.spring.cab.cabBookingApp.Service.BookingService;
import com.spring.cab.cabBookingApp.Service.DriverService;
import com.spring.cab.cabBookingApp.Service.UserService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private DriverService driverService;
	
	
	@PostMapping("/searchRide")
	public List<String> findRide(@RequestParam("name") String name, @RequestParam("destination") String dest) {
		List<String> list=new ArrayList<>();
		try {
		User user =userService.getUser(name);
		
		if(user==null) {
			list.add("No such user");
			return list;
		}
		List<Driver> drivers= bookingService.findDrivers(user.getX_coordinate(), user.getY_coordinate());
		if(drivers!=null && !drivers.isEmpty()) {
			for(Driver driver: drivers) {
				if(driver.isStatus()) {
					list.add(driver.getName());
				}
			}
		}
		if(list.isEmpty()) {
			list.add("No driver found");
		}
		return list;
		}catch(Exception e) {
			e.printStackTrace();
			list.add("Please try after sometime as there is some internal server error");
			return list;
		}
		
	}
	
	@PostMapping("/chooseRide")
	public String chooseRide(@RequestParam("name") String name, @RequestParam("Driver-Name") String driver, @RequestParam("destination") String dest) {
		
		try {
			String[] destArr=dest.split(",");
			driverService.updateDriverLocation(driver, Integer.parseInt(destArr[0]), Integer.parseInt(destArr[1]));
			userService.updateUser(name, Integer.parseInt(destArr[0]), Integer.parseInt(destArr[1]));
			return "Ride Started";
		}catch(Exception e) {
			e.printStackTrace();
			return "Ride caanot be strted right now";
		}
	}
	
	
}
