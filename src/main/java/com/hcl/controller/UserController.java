package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.service.UserService;
import com.hcl.to.User;

import ch.qos.logback.core.model.Model;

@Controller
public class UserController {

	public UserController() {
		System.out.println("inside userController constr...");
	}

	@Autowired
	UserService service;

	@GetMapping("/")
	public String indexPage() {

		System.out.println("inside indexPage()");

		return "index";
	}

	@GetMapping("/registrationPage")
	public String registrationPage() {

		System.out.println("inside registrationPage()");

		return "registration_page";
	}

//	@PostMapping("/register")
//	public String registerUser(String username, String password, String name, String email) {
//		
//		System.out.println("inside registerPage..."+username+", "+password+", "+name+", "+email);
//		
//		UserService service = new UserService();
//		
//		service.addUser(username, password, name, email);
//		
//		return "index";
//		
//	}

	@PostMapping("/register")
	public String registerUser(User user) {

		System.out.println("inside registerPage..." + user.getUsername() + ", " + user.getPassword() + ", "
				+ user.getName() + ", " + user.getEmail());

		service.addUser(user);

		return "index";

	}

//	@PostMapping("/login")
//	public String login(String uname, String pwd) {
//
//		System.out.println("inside login()..." + uname + ", " + pwd);
//
//		String loginStatus = service.validate(uname, pwd);
//
//		if (loginStatus.equals("Success")) {
//			return "welcome";
//		} else {
//			return "index";
//		}
//	}

//	@PostMapping("/login")
//	public ModelAndView login(String uname, String pwd) {
//
//		System.out.println("inside login()..." + uname + ", " + pwd);
//
//		String loginStatus = service.validate(uname, pwd);
//
//		if (loginStatus.equals("Success")) {
//			
//			ModelAndView modelAndView = new ModelAndView("welcome");
//			modelAndView.addObject("username", uname);
//			return modelAndView;
//			
//		} else {
//			
//			ModelAndView modelAndView = new ModelAndView("index");
//			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again!!!");
//			return modelAndView;
//		}
//	}

	@PostMapping("/login")
	public ModelAndView login(String uname, String pwd) {

		System.out.println("inside login()..." + uname + ", " + pwd);

		User user = service.validate(uname, pwd);

		if (user != null) {

			ModelAndView modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("userData", user);
			return modelAndView;

		} else {

			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again!!!");
			return modelAndView;
		}
	}

	@GetMapping("/delete/{username}")
	public ModelAndView deleteByUsername(@PathVariable String username) {

		System.out.println("The username fetched is " + username);

		service.delete(username);

		List<User> users = service.getUsers();

		ModelAndView modelAndView = new ModelAndView("user_master");

		modelAndView.addObject("allusers", users);

		return modelAndView;

	}

	@GetMapping("/updatePage/{username}")
	public ModelAndView updatePage(@PathVariable String username) {

		System.out.println("inside updateUser " + username);

		User user = service.findByusername(username);

		ModelAndView modelAndView = new ModelAndView("update_user");
		modelAndView.addObject("userdata", user);

		return modelAndView;
	}

	@PutMapping("/update")
	public ModelAndView updateUser(User user) {

		System.out.println("user is " + user.getUsername());

		List<User> users = service.getUsers();

		ModelAndView modelAndView = new ModelAndView("user_master");

		modelAndView.addObject("allusers", users);
		
		return modelAndView;
	}
}
