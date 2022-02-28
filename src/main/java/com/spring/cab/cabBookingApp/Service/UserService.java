package com.spring.cab.cabBookingApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.cab.cabBookingApp.Entity.User;

@Service
public class UserService {

	private List<User> userList=null;
	
	public UserService(){
		this.userList=new ArrayList<>();
	}
	
	public List<User> addUserToList(User user) {
		userList.add(user);
		return userList;
	}

	public User updateUser(String name, int x_coor, int y_coor) {
		User updatedUser=null;
		
		for(User user: userList) {
			if(user.getName().equalsIgnoreCase(name)) {
				user.setX_coordinate(x_coor);
				user.setY_coordinate(y_coor);
				updatedUser=user;
			}
		}
		return updatedUser;			
	}

	public User updateUser(String name, String phone) {
		User updatedUser=null;
		
		for(User user: userList) {
			if(user.getName().equalsIgnoreCase(name)) {
				user.setPhone(phone);	
				updatedUser=user;
			}
		}
		return updatedUser;	
	}
	
	public User getUser(String name) {
		return (User)userList.stream().filter(u->u.getName().equalsIgnoreCase(name)).findFirst().get();
	}
	
	
}
