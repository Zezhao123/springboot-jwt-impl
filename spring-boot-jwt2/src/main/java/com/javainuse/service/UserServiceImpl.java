package com.javainuse.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
	
	private final UserDao userRepo;

	@Override
	public DAOUser saveUser(DAOUser user) {
		log.info("saving user {}", user.getUsername());
		return userRepo.save(user);
	}

	@Override
	public DAOUser getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DAOUser> getUsers() {
		log.info("getting all user");
		return (List<DAOUser>) userRepo.findAll();
	}
	
	@Override
	public DAOUser getUserById(Long id) {
		//  convert from an option to an entity. /* Throw exception if user was not found*/
		return userRepo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}


//	@Override
//	public DAOUser updateUser(Long id, DAOUser user) {
//		
//		DAOUser updateEmployee = ((UserServiceImpl) userRepo).getUserById(id);
//		updateEmployee.setAddress(user.getAddress());
//		updateEmployee.setCity(user.getCity());
//		updateEmployee.setPhone(user.getPhone());
//		updateEmployee.setSsn(user.getSsn());
//		return userRepo.save(updateEmployee);
//
//	}
	
}
