package com.sonndc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonndc.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	
	User findById(long id);
	
	List<User> findAll();
}
