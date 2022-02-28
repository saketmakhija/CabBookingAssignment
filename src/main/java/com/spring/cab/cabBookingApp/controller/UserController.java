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

import com.spring.cab.cabBookingApp.Entity.User;
import com.spring.cab.cabBookingApp.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<List<User>> addUser(@RequestBody User user) {
		
		List<User> userList=null;
		try {
		userList = userService.addUserToList(user);
		return ResponseEntity.of(Optional.of(userList));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@PostMapping("/updateLocation")
	public ResponseEntity<User> updateUserLocation(@RequestParam("name") String name, @RequestParam("x") int x_coor, @RequestParam("y") int y_coor) {
		
		try {
			User user = userService.updateUser(name, x_coor, y_coor);
			if(user==null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			return ResponseEntity.of(Optional.of(user));
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}	
	}
	
	@PostMapping("/updatePhone")
	public ResponseEntity<User> updateUserDetails(@RequestParam("name") String name, @RequestParam("phone") String phone) {

		try {
			User user = userService.updateUser(name, phone);
			if(user==null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			return ResponseEntity.of(Optional.of(user));
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}	
	}
}
