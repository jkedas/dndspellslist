package com.example.dndspellslist.controllers;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.dndspellslist.entity.User;
import com.example.dndspellslist.model.CustomUserDetails;

public class BaseController {

	public BaseController() {
	}
	
	public User getCurrentUser() {
		return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}
}
