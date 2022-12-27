package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.service.UserService;
import com.hcl.to.User;

@Controller
public class MasterController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/masterPage")
	public String getMasterPage( ) {
		
		System.out.println("inside getMasterPage...");
		
		return "master_page";
	}
	
	@GetMapping("/userMaster")
	public ModelAndView userMasterPage() {
		
		System.out.println("inside userMasterpage");
		
		List<User> users = service.getUsers();
		
		System.out.println("siz eis "+users.size());
		
		ModelAndView modelAndView = new ModelAndView("user_master");
		
		modelAndView.addObject("allusers", users);
		
		return modelAndView;
	}

}
