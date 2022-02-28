package com.spring.cab.cabBookingApp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.cab.cabBookingApp.Entity.User;
import com.spring.cab.cabBookingApp.Service.UserService;

class UserControllerTest {
	
	@Autowired
	private UserController userController;

	@Mock
	private UserService userService;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testAddUser() throws Exception {
		
		//mock the user data which we are adding
		
		ArrayList list = new ArrayList();
		User user = new User("Saket", "M", 25);
		list.add(user);
		
		Mockito.when(userService.addUserToList(user)).thenReturn(list);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/add")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(mockRequest)
			.andExpect(status().isOk());
		
	}

	@Test
	void testUpdateUserLocation() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUserDetails() {
		fail("Not yet implemented");
	}

}
