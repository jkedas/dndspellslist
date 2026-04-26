package com.example.dndspellslist.controllers;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dndspellslist.entity.PlayerCharacter;
import com.example.dndspellslist.entity.Spell;
import com.example.dndspellslist.model.PlayerCharacterModel;
import com.example.dndspellslist.service.PlayerCharacterService;
import com.example.dndspellslist.service.SpellService;

@Controller
public class SpellListController extends BaseController{

		PlayerCharacterService pcService;
		SpellService spellService;
		
		public SpellListController(PlayerCharacterService pcService, SpellService spellService) {
			this.pcService = pcService;
			this.spellService = spellService;
		}
	//does nothing right now
		@GetMapping("character/spell-list")
		public String viewCharacterSpellList(@RequestParam(name="id", required=true) Integer pc_id, Model model) {
			PlayerCharacterModel pc = pcService.loadById(pc_id);
			model.addAttribute("character", pc.getPlayerCharacter());
			
			HashMap<String, List<Spell>> character_spells = pcService.sortSpells(pc.getSpellList());
			model.addAttribute("char0", character_spells.get("cantrip"));
		    model.addAttribute("char1", character_spells.get("one"));
		    model.addAttribute("char2", character_spells.get("two"));
		    model.addAttribute("char3", character_spells.get("three"));
		    model.addAttribute("char4", character_spells.get("four"));
		    model.addAttribute("char5", character_spells.get("five"));
		    model.addAttribute("char6", character_spells.get("six"));
		    model.addAttribute("char7", character_spells.get("seven"));
		    model.addAttribute("char8", character_spells.get("eight"));
		    model.addAttribute("char9", character_spells.get("nine"));
		    
		    model.addAttribute("cantrip_list", spellService.loadByLevel(0));
		    model.addAttribute("one_list", spellService.loadByLevel(1));
		    model.addAttribute("two_list", spellService.loadByLevel(2));
		    model.addAttribute("three_list", spellService.loadByLevel(3));
		    model.addAttribute("four_list", spellService.loadByLevel(4));
		    model.addAttribute("five_list", spellService.loadByLevel(5));
		    model.addAttribute("six_list", spellService.loadByLevel(6));
		    model.addAttribute("seven_list", spellService.loadByLevel(7));
		    model.addAttribute("eight_list", spellService.loadByLevel(8));
		    model.addAttribute("nine_list", spellService.loadByLevel(9));
		    
			return "character/spell-list";
		}
		
		@PostMapping("/update-spell-list")
		public String processSave(@ModelAttribute("character") PlayerCharacter pc) {
			PlayerCharacter newPc = pcService.loadById(pc.getCharacter_id()).getPlayerCharacter();
			newPc.setSpells(pc.getSpells());
			pcService.saveCharacter(newPc);
			return "redirect:/character/spell-list?id=" + pc.getCharacter_id();
		}
		
		@PostMapping("/add-spell")
		public String addSpell(@RequestParam int pc_id, @RequestParam(name="add_id", required=true) Integer spell_id, Model model) {
			Spell spell = spellService.loadById(spell_id);
			PlayerCharacter pc = pcService.loadById(pc_id).getPlayerCharacter();
			
			List<Spell> temp;
			if (pc.getSpells()!=null) {
				temp = pc.getSpells();
			}
			else {
				temp = new ArrayList<>();
			}
			temp.add(spell);
			
			PlayerCharacter newPc = pcService.loadById(pc.getCharacter_id()).getPlayerCharacter();
			newPc.setSpells(temp);
			pcService.saveCharacter(newPc);
			
			model.addAttribute("character", newPc);
			
			return "fragments/spell-table :: spell-list-form";
		}
		
		@PostMapping("/remove-spell")
		public String removeSpell(@RequestParam int pc_id, @RequestParam(name="remove_id", required=true) Integer spell_id, Model model) {
			Spell spell = spellService.loadById(spell_id);
			PlayerCharacter pc = pcService.loadById(pc_id).getPlayerCharacter();
			
			List<Spell> temp = pc.getSpells();
			temp.removeIf(s -> s.getSpell_id() == spell.getSpell_id());
			
			PlayerCharacter newPc = pcService.loadById(pc.getCharacter_id()).getPlayerCharacter();
			newPc.setSpells(temp);
			pcService.saveCharacter(newPc);
			
			model.addAttribute("character", newPc);
			System.out.println("First Spell: " + newPc.getSpells().get(0).getName());
			
			return "fragments/spell-table :: spell-list-form";
		}
		
		
		
		
		
		
}
