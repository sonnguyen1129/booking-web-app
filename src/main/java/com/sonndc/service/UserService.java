package com.sonndc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonndc.entity.User;
import com.sonndc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser() {
		List<User> list = userRepository.findAll();
		return list;
	};
	
	public User getUserById(long id) {
		return userRepository.findById(id);
	}
}
