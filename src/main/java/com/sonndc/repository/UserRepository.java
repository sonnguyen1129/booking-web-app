package com.sonndc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonndc.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
