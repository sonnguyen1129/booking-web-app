package com.sonndc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonndc.entity.User;
import com.sonndc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public void welcome(SecurityContextHolderAwareRequestWrapper request) {
		System.out.println(request);
	    boolean b = request.isUserInRole("ROLE_ADMIN");
	    System.out.println("ROLE_ADMIN=" + b);

	    boolean c = request.isUserInRole("ROLE_USER");
	    System.out.println("ROLE_USER=" + c);
	}
	
	@GetMapping("/all")
	public List<User> getAllUser() {
		List<User> list = userService.getAllUser();
		return list;
	}
	
	@GetMapping("/current-user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable (name = "userId") String userId) {
		User user = userService.getUserById(Integer.parseInt(userId));
		return ResponseEntity.ok(user);
	}

}