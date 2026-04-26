package com.example.dndspellslist.model;


import com.example.dndspellslist.entity.Spell;

public class SpellDetails {

	private Spell spell;
	public SpellDetails(Spell spell) {
		this.spell = spell;
	}
	
	public String getSpellName() {
		return spell.getName();
	}
	
	
}
