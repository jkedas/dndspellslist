package com.example.dndspellslist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dndspellslist.entity.User;
import com.example.dndspellslist.exceptions.CustomUserDetailsException;
import com.example.dndspellslist.service.UserService;

@Controller
public class UserDisplayController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	
	@PostMapping("/process_register")
	public String processRegister(User user, Model model) {
		try {
            userService.registerUser(user);
            return "/index";
        } catch (CustomUserDetailsException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "/index";
        }

	}
	
}
