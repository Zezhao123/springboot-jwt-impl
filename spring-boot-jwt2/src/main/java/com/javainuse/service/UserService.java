package com.javainuse.service;

import java.util.List;
import java.util.Optional;

import com.javainuse.model.DAOUser;

public interface UserService {
	
	DAOUser saveUser(DAOUser user);
	
	DAOUser getUserByUserName(String username);
	List<DAOUser>getUsers();

	DAOUser getUserById(Long id);

	void deleteUser(Long id);

//	DAOUser updateUser(Long id, DAOUser user);




	
	
	
}