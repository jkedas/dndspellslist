package com.example.dndspellslist.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.example.dndspellslist.entity.PlayerCharacter;
import com.example.dndspellslist.entity.Spell;
import com.example.dndspellslist.entity.User;
import com.example.dndspellslist.exceptions.PlayerCharacterException;
import com.example.dndspellslist.model.PlayerCharacterModel;
import com.example.dndspellslist.repository.PlayerCharacterRepository;

@Service
public class PlayerCharacterService extends BaseService {

	
	private final PlayerCharacterRepository charRepo;
	public PlayerCharacterService(PlayerCharacterRepository charRepo) {
		this.charRepo = charRepo;
	}
	
	public PlayerCharacterModel loadById(long id) throws AccessDeniedException {
		User current = getCurrentUser();
		PlayerCharacter pc = charRepo.findById(id);
		if (current.getId() != pc.getUser().getId()) {
			throw new AccessDeniedException("User: " + current.getId() + " does not have permission to access Character: " + pc.getCharacter_id());
		}
		return new PlayerCharacterModel(pc);
		
	}
	
	public PlayerCharacter saveCharacter(PlayerCharacter pc) throws PlayerCharacterException{
		try {
			return charRepo.save(pc);
		}
		catch (DataIntegrityViolationException ex) {
			throw new PlayerCharacterException("Required Parameter is missing: ", ex);
		}
			
	}
	
	public List<PlayerCharacter> getCharacters() {
		return charRepo.findAll();
	}
	
	public List<PlayerCharacter> getCharactersByUser(long id) throws AccessDeniedException {
		User current = getCurrentUser();
		if (current.getId() != id) {
			throw new AccessDeniedException("User: " + current.getId() + " does not have permission to access those Characters");
		}
		return charRepo.findByUser(id);
	}
	
	public PlayerCharacter saveSpellList(PlayerCharacter pc, List<Spell> spell_list) {
		pc.setSpells(spell_list);
		return charRepo.save(pc);
	}
	
	public HashMap<String, List<Spell>> sortSpells(List<Spell> spells) {
		
		HashMap<String, List<Spell>> sorted = new HashMap<>();
		
		sorted.put("cantrip", new ArrayList<>());
		sorted.put("one", new ArrayList<>());
		sorted.put("two", new ArrayList<>());
		sorted.put("three", new ArrayList<>());
		sorted.put("four", new ArrayList<>());
		sorted.put("five", new ArrayList<>());
		sorted.put("six", new ArrayList<>());
		sorted.put("seven", new ArrayList<>());
		sorted.put("eight", new ArrayList<>());
		sorted.put("nine", new ArrayList<>());

		
		
		for(Spell spell : spells) {
			switch (spell.getLevel()) {
				case 0:  sorted.get("cantrip").add(spell); break;
				case 1:  sorted.get("one").add(spell); break;
				case 2:  sorted.get("two").add(spell); break;
				case 3:  sorted.get("three").add(spell); break;
				case 4:  sorted.get("four").add(spell); break;
				case 5:  sorted.get("five").add(spell); break;
				case 6:  sorted.get("six").add(spell); break;
				case 7:  sorted.get("seven").add(spell); break;
				case 8:  sorted.get("eight").add(spell); break;
				case 9:  sorted.get("nine").add(spell); break;
			}
		}
		
		
		return sorted;
	}
	
}
