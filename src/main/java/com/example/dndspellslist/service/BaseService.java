package com.example.dndspellslist.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.dndspellslist.entity.User;
import com.example.dndspellslist.model.CustomUserDetails;

public class BaseService {
	public BaseService() {
	}
	
	public User getCurrentUser() {
		return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}
}
