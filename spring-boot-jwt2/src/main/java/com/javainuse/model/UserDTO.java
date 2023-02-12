package com.javainuse.model;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private String address;
	private String phone;
	private String ssn;
	private String city;
}