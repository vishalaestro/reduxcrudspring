package com.reduxcrud.reduxcrud;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RestController
public class UserController {
	
	@GetMapping("/listUsers")
	public List<User> getUserList() throws Exception {
		try {
			return UserList.users;
		}
		catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User addUser) throws Exception {
		try {
			return UserList.addUser(addUser);
		}
		catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@GetMapping("/get")
	public User getUser(@RequestParam Integer uuId) throws Exception {
		try {
			return UserList.getUser(uuId);
		}
		catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping("/edit")
	public User editUser(@RequestBody User editUser) throws Exception {
		try {
			return UserList.editUser(editUser);
		}
		catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping("/delete")
	public void deleteUser(@RequestBody User user) throws Exception {
		try {
		 UserList.deleteUser(user.getUuId());
		}
		catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
