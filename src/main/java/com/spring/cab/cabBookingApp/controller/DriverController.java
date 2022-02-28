package com.spring.cab.cabBookingApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cab.cabBookingApp.Entity.Driver;
import com.spring.cab.cabBookingApp.Entity.User;
import com.spring.cab.cabBookingApp.Service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@PostMapping("/add")
	public ResponseEntity<List<Driver>> addDriver(@RequestBody Driver driver){
		
		List<Driver> driverList=null;
		try {
		driverList = driverService.addDriverToList(driver);
		return ResponseEntity.of(Optional.of(driverList));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/updateLocation")
	public ResponseEntity<Driver> updateDriver(@RequestParam("name") String name, @RequestParam("x") int x_coor, @RequestParam("y") int y_coor){
		
		try {
			Driver driver = driverService.updateDriverLocation(name, x_coor, y_coor);
			if(driver==null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			return ResponseEntity.of(Optional.of(driver));
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
	@PostMapping("/updateStatus")
	public ResponseEntity<Driver> updateStatus(@RequestParam("name") String name, @RequestParam("status") boolean status) {
		
		try {
			Driver driver = driverService.updateDriverStatus(name, status);
			if(driver==null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			return ResponseEntity.of(Optional.of(driver));
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
	}
}
