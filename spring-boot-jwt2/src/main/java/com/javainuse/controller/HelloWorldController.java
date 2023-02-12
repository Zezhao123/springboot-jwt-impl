package com.javainuse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javainuse.model.DAOUser;
import com.javainuse.service.UserService;
import com.javainuse.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class HelloWorldController {
	
	private final UserService userService;
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@GetMapping({ "/get/users" })
	public ResponseEntity<List<DAOUser>>getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
//	@PostMapping({ "/user/save" })
//	public ResponseEntity<DAOUser>saveUser(@RequestBody DAOUser user){
//		return ResponseEntity.ok().body(userService.saveUser(user));
//	}
	
	@PutMapping({"/update/user/{id}"})
	public ResponseEntity<DAOUser> updateUser( @PathVariable("id") Long id,  @RequestBody DAOUser user) {
		DAOUser updateEmployee = userService.getUserById(id);
		if(user.getAddress()!= null)
			updateEmployee.setAddress(user.getAddress());
		if(user.getCity()!= null)
			updateEmployee.setCity(user.getCity());
		if(user.getPhone()!= null)
			updateEmployee.setPhone(user.getPhone());
		if(user.getSsn()!= null)
			updateEmployee.setSsn(user.getSsn());
		userService.saveUser(updateEmployee);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	@DeleteMapping({"delete/user/{id}"})
	public ResponseEntity<String> deleteUser( @PathVariable("id") Long id){
		userService.deleteUser(id);

//		return ResponseEntity.ok().body(id);
		return new ResponseEntity<String>("User with '"+id+"' has been deleted",HttpStatus.OK);
	}
	
	
	
	

}