package com.sonndc.dto;

import lombok.Data;

@Data
public class UserDTO {
	private long id;
	private String username;
	private String phone;
	private String password;
	private String role;
	private String token;
	
	public UserDTO(long l, String username, String phone, String role, String token) {
		super();
		this.id = l;
		this.username = username;
		this.phone = phone;
		this.role = role;
		this.token = token;
	}
}