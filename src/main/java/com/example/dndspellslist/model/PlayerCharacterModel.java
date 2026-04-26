package com.example.dndspellslist.model;


import java.util.ArrayList;
import java.util.List;

import com.example.dndspellslist.entity.PlayerCharacter;
import com.example.dndspellslist.entity.Spell;

public class PlayerCharacterModel {
	
	private PlayerCharacter pc;
	public PlayerCharacterModel(PlayerCharacter pc) {
		this.pc = pc;
	}
	
	public PlayerCharacter getPlayerCharacter() {
		return pc;
	}
	
	public List<Spell> getSpellList() {
		List<Spell> spells = pc.getSpells();
		List<Spell> cantrip = new ArrayList<>();
		List<Spell> one = new ArrayList<>();
		List<Spell> two = new ArrayList<>();
		List<Spell> three = new ArrayList<>();
		List<Spell> four = new ArrayList<>();
		List<Spell> five = new ArrayList<>();
		List<Spell> six = new ArrayList<>();
		List<Spell> seven = new ArrayList<>();
		List<Spell> eight = new ArrayList<>();
		List<Spell> nine = new ArrayList<>();
		
		
		for(Spell spell : spells) {
			switch (spell.getLevel()) {
				case 0:  cantrip.add(spell); break;
				case 1:  one.add(spell); break;
				case 2:  two.add(spell); break;
				case 3:  three.add(spell); break;
				case 4:  four.add(spell); break;
				case 5:  five.add(spell); break;
				case 6:  six.add(spell); break;
				case 7:  seven.add(spell); break;
				case 8:  eight.add(spell); break;
				case 9:  nine.add(spell); break;
			}
		}
		
		
		return spells;
	}

	
	
}
