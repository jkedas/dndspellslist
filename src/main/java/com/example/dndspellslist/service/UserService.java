package com.example.dndspellslist.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dndspellslist.entity.User;
import com.example.dndspellslist.exceptions.CustomUserDetailsException;
import com.example.dndspellslist.repository.UserRepository;

@Service //handles saving users to database (registration)
public class UserService {

	private final UserRepository userRepo; 
	private final BCryptPasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	//saving the user's registration data
	public User registerUser(User user) {
		//catch the exception
		//check if the user already exists (check by email)
		 if ( userRepo.existsByEmail(user.getEmail()) ) {
			 throw new CustomUserDetailsException("account already exists");
		 }
		user.setPassword(passwordEncoder.encode(user.getPassword())); //gets, encodes, then saves encoded password
		try {
			return userRepo.save(user); //saves user to database and returns the user object to controller
		} 
		catch (DataIntegrityViolationException ex) {
			if(userRepo.existsByEmail(user.getEmail())) {
				throw new CustomUserDetailsException("Email already existst.", ex);
			}
			throw ex;
		}
	}	
	
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}
	
	
}
