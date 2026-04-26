package com.example.dndspellslist.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dndspellslist.service.RestClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



@Controller
public class HomeNavController {

	@Autowired RestClientService restClient;
	public HomeNavController() {
	}
	
	@GetMapping({"", "/", "/home"})
	public String viewHomePage() {

		return "index";
	}
	
	@GetMapping("/update-spells")
	public String updateSpells() {
		try {
			restClient.fetchSpells();
			return "index";
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "index";
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "index";
		}
		
	}
	


	
}
