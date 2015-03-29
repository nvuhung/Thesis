package com.hung.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hung.ws.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/hello/{username}", method = RequestMethod.GET)
	public String goHello(@PathVariable("username") String username) {
		return "Hello " + "<b>" + username + "</b>";
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public User getUser() {
		User user = new User();
		user.setUsername("nvuhungit");
		user.setPassword("123456");
		return user;
	}

	@RequestMapping(value = "/getlistuser", method = RequestMethod.GET)
	public List<User> getListUser() {
		List<User> result = new ArrayList<User>();
		User user = new User();
		user.setUsername("nvuhungit");
		user.setPassword("123456");
		result.add(user);
		User user2 = new User();
		user2.setUsername("maithanh");
		user2.setPassword("987654");
		result.add(user2);
		return result;
	}

	@RequestMapping(value = "/salary/{value}", method = RequestMethod.GET)
	public String showSalary(@PathVariable("value") int salary) {
		String result = "";
		if (salary <= 10)
			result = "Low";
		else if (salary > 10 && salary <= 20)
			result = "Medium";
		else
			result = "High";
		return result;
	}
	
	@RequestMapping(value = "/showuser", method = RequestMethod.POST)
	public String showUser(@RequestBody User user) {
		String result = "--->User's profile is: \n";
		result += "User name: " + user.getUsername() + "\n";
		result += "Password: " + user.getPassword() + "\n";
		result += "Salary: " + user.getSalary() + "\n";
		return result;
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String getAddress(@RequestParam(value = "district", defaultValue = "Tan Binh") String district,
			@RequestParam(value = "city", defaultValue = "Ho Chi Minh City") String city) {
		return "Your address: " + district + " - " + city;
	}
}
