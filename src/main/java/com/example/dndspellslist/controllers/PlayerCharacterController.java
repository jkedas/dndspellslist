package com.example.dndspellslist.controllers;

import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dndspellslist.entity.PlayerCharacter;
import com.example.dndspellslist.exceptions.PlayerCharacterException;
import com.example.dndspellslist.model.PlayerCharacterModel;
import com.example.dndspellslist.service.PlayerCharacterService;

@Controller
public class PlayerCharacterController extends BaseController{

	
	
	private final PlayerCharacterService pcService;
	public PlayerCharacterController(PlayerCharacterService pcService) {
		this.pcService = pcService;
	}
	

	@GetMapping("/character-select")
	public String viewCharacters(Model model) {
		try {
			List<PlayerCharacter> pc = pcService.getCharactersByUser(getCurrentUser().getId());
			model.addAttribute("characters", pc);
			return "character-select";
		}
		catch (AccessDeniedException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "redirect:/";
		}
		
	}
	
	
	//handles the loading of the character sheet
	@GetMapping("character/character-sheet")
	public String viewCharacterSheet(@RequestParam(name="id", required=true) Integer pc_id, Model model) {
		try {
			PlayerCharacterModel pc = pcService.loadById(pc_id); //gets most character information
			model.addAttribute("character", pc.getPlayerCharacter()); //adds character information
			return "character/character-sheet";
		}
		catch (AccessDeniedException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "redirect:/character-select";
		}
		
	}
	
	//handles saving a character sheet
	@PostMapping("/update-character")
	public String processSave(PlayerCharacter pc, Model model) {
		try {
			pcService.saveCharacter(pc);
			model.addAttribute("character", pc);
			return "redirect:/character/character-sheet?id=" + pc.getCharacter_id();
		}
		catch (AccessDeniedException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "redirect:/character-select";
		}
		catch(PlayerCharacterException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "redirect:/character/character-sheet?id=" + pc.getCharacter_id();
		}
	}
	
	@GetMapping("create-character")
	public String showCharacterCreationForm(Model model) {
		
		PlayerCharacter pc = new PlayerCharacter();
		pc.setUser(getCurrentUser());
		model.addAttribute("character", pc);
		
		return "create-character";
	}
	
	@PostMapping("process-create-character")
	public String processCharacterCreation(PlayerCharacter pc) {
		pcService.saveCharacter(pc);
		
		String newSheet = "redirect:/character/character-sheet?id=" + pc.getCharacter_id();
		
		return newSheet;
	}
	
	
	

	
	
}
