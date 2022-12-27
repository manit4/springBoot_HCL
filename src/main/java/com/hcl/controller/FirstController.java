package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.to.User;

@RestController
@RequestMapping("/restapi")
public class FirstController {
	
	@GetMapping("/message")
	public String greetingMessage() {
		
		return "Hi there!!";
	}
	
	@GetMapping("/secondMessage")
	public String secondMesage() {
		
		return "Hoping, everything is going good and I am updating the message...";
	}
	
//	@GetMapping("/getUser")
//	public User getUser() {
//		
//		User user = new User("suh@123", "1234", "Suhail Ali", "ali_suhail@yahoo.com", 98989898);
//		
//		return user;
//	}
//	
//	@GetMapping("/getUsers")
//	public List<User> getUsers() {
//		
//		
//		User user1 = new User("sha@123", "6789", "Shalini", "Singh", 78787878);
//		User user2 = new User("nav@345", "4567", "Navya", "Kalyani", 98989898);
//		User user3 = new User("suh@123", "1234", "Suhail Ali", "ali_suhail@yahoo.com", 98989898);
//		User user4 = new User("har@657", "6576", "Harkirat", "Singh", 45454545);
//		
//		List<User> users = new ArrayList<User>();
//		
//		users.add(user1);   users.add(user2);   users.add(user3);   users.add(user4);
//		
//		return users;
//	}

}
