package com.example.dndspellslist.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dndspellslist.entity.Spell;
import com.example.dndspellslist.model.SpellDetails;
import com.example.dndspellslist.repository.SpellRepository;


@Service
public class SpellService {

	//@Autowired
	private final SpellRepository spellRepo;
	public SpellService(SpellRepository spellRepo) {
		this.spellRepo = spellRepo;
	}
	
	
	public SpellDetails loadByName(String spellname) {
		Spell spell = spellRepo.findByName(spellname);
		return new SpellDetails(spell);
	}
	
	public List<Spell> loadByLevel(Integer level) {
		List<Spell> spells = spellRepo.findByLevel(level);
		return spells;
	}
	
	public Spell loadById(Integer spell_id) {
		return spellRepo.findById(spell_id);
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
