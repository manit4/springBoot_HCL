package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.repository.UserRepository;
import com.hcl.to.User;

@Service
public class UserService {

	public UserService() {
		System.out.println("inside Userservice constr...");
	}

	@Autowired
	UserRepository repository;

//	public void addUser(String username, String password, String name, String email) {
//		
//		UserRepository repository = new UserRepository();
//		
//		repository.saveUser(username, password, name, email);
//	}

	public void addUser(User user) {

		repository.saveUser(user);
	}

//	public String validate(String username, String password) {
//		
//		String status = repository.findUser(username, password);
//		
//		return status;
//		
//	}

	public User validate(String username, String password) {

		User user = repository.findUser(username, password);

		return user;

	}
	
	public List<User> getUsers() {
		
		return repository.getUsers();
	}
	
	public void delete(String username) {
		
		repository.deleteByUsername(username);
	}
	
	public User findByusername(String username) {
		
		return repository.findUser(username);
	}
	
	public void update(User user) {
		
		repository.update(user);
	}
}
