package com.techbee.userprofileapi.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

	@Autowired
	UserProfileDao javaSDETDAO = new UserProfileDao();
	
	
	@GetMapping("/displayAllUsers")
	public List<UserProfile> displayAllUsers() {
		return javaSDETDAO.getAllUsers();
		
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserProfile newUser) {
		
		javaSDETDAO.addUser(newUser);
		return newUser.getFirstName() +  " " + newUser.getLastName() + " added successfully!";
		
	}
	
	//Implement Delete
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable int userId) {
		UserProfile user = javaSDETDAO.getUser(userId);
		if(user != null) {
			javaSDETDAO.deleteUser(userId);
			return "User " + userId + " deleted";
		}
		return "User Not found";
		
	}
	
	//Implement search user by name
	@GetMapping("/{userId}")
	public UserProfile displayUser(@PathVariable int userId) {
		return javaSDETDAO.getUser(userId);
	}
	
	//Implement update
	@PutMapping("/{userId}")
	public String updateUser(@RequestBody UserProfile user) {
		
		javaSDETDAO.updateUser(user);
		return user.getFirstName() +  " " + user.getLastName() + " updated successfully!";
		
	}
}
