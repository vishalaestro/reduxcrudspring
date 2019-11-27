package com.reduxcrud.reduxcrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserList {

	public static List<User> users = new ArrayList<User>();
	
	public static User addUser(User addUser) throws Exception {
		for(User user : users) {
			if(user.getPhoneNumber().equals(addUser.getPhoneNumber())) {
				throw new Exception ("User already exists");
			}
		}
		addUser.setUuId(new Random().nextInt(8));
		users.add(addUser);
		return addUser;
	}
	
	public static User getUser (Integer uuId) throws Exception {
		for(User user : users) {
			if(user.getUuId().equals(uuId)) {
				return user;
			}
		}
		return null;
	}
	
	public static User editUser(User editUser) throws Exception {
		int indexToEdit = 0;
		int i =0;
		for(User user : users) {
			if(user.getUuId().equals(editUser.getUuId())) {
				indexToEdit = i;
			}
			i++;
		}
		User userToEdit = users.get(indexToEdit);
		userToEdit.setAddress(editUser.getAddress());
		userToEdit.setCompany(editUser.getCompany());
		userToEdit.setDesignation(editUser.getDesignation());
		userToEdit.setEmailId(editUser.getEmailId());
		userToEdit.setFirstName(editUser.getFirstName());
		userToEdit.setLastName(editUser.getLastName());
		userToEdit.setProfileImage(editUser.getProfileImage());
		users.set(indexToEdit, userToEdit);
		return editUser;
	}
	
	public static void deleteUser(Integer uuId) throws Exception {
		int indexToDelete = 0;
		int i =0;
		for(User user : users) {
			if(user.getUuId() == uuId) {
				indexToDelete = i;
			}
			i++;
		}
		users.remove(indexToDelete);
	}
	
}
