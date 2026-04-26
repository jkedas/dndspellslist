package com.example.dndspellslist.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dndspellslist.entity.User;
import com.example.dndspellslist.model.CustomUserDetails;
import com.example.dndspellslist.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	//@Autowired  the repository is 'injected' by this constructor
	private final UserRepository userRepo;
	public CustomUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	//get the data from database method
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}
