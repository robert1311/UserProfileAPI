package com.techbee.userprofileapi.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserProfileDao {


	ArrayList<UserProfile> users = new ArrayList<>();
	
	public void addUser(UserProfile user) {
			users.add(user);
		
	}

	public UserProfile getUser(int userId) {
		UserProfile selectedUser = null;
		for (UserProfile user : users) {
			if (user.getUserProfileId() == userId) {
				selectedUser = user;
				;
			}
		}
		return selectedUser;
	}

	public List<UserProfile> getAllUsers() {
		return users;
	}

	public void updateUser(UserProfile user) {
//		int index = users.indexOf(user);
//		users.remove(users.indexOf(user));
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserProfileId() == user.getUserProfileId()){
				users.remove(i);
				users.add(i, user);
				break;
			}
		}
		
	}

	public boolean deleteUser(int userId) {
		UserProfile user = getUser(userId);
		if (user == null) {
			return false;
		} else {
			users.remove(user);
			return true;
		}
	}
}
