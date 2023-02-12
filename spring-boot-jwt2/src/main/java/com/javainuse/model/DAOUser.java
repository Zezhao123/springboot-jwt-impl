package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	
	@Column
	private String address;
	
	@Column
	private String phone;
	
	@Column
	private String ssn;
	
	@Column
	private String city;
	

	

}
