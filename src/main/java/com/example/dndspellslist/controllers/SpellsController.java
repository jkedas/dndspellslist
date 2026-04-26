package com.example.dndspellslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dndspellslist.entity.Spell;
import com.example.dndspellslist.repository.SpellRepository;

@Controller
public class SpellsController {

	@Autowired
	private SpellRepository spellRepo;
	
	@GetMapping("/spells")
	public String renderSpellList(Model model) {
		
		List<Spell> cantrip = spellRepo.findByLevel(0);
		List<Spell> one = spellRepo.findByLevel(1);
		List<Spell> two = spellRepo.findByLevel(2);
		List<Spell> three = spellRepo.findByLevel(3);
		List<Spell> four = spellRepo.findByLevel(4);
		List<Spell> five = spellRepo.findByLevel(5);
		List<Spell> six = spellRepo.findByLevel(6);
		List<Spell> seven = spellRepo.findByLevel(7);
		List<Spell> eight = spellRepo.findByLevel(8);
		List<Spell> nine = spellRepo.findByLevel(9);
		
		
		model.addAttribute("cantrip_list", cantrip);
		model.addAttribute("one_list", one);
		model.addAttribute("two_list", two);
		model.addAttribute("three_list", three);
		model.addAttribute("four_list", four);
		model.addAttribute("five_list", five);
		model.addAttribute("six_list", six);
		model.addAttribute("seven_list", seven);
		model.addAttribute("eight_list", eight);
		model.addAttribute("nine_list", nine);

		return "spells";
	}
	
}
