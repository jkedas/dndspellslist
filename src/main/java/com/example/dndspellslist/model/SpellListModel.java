package com.example.dndspellslist.model;

import java.util.List;

import com.example.dndspellslist.entity.PlayerCharacter;
import com.example.dndspellslist.entity.Spell;

public class SpellListModel {
	
	private List<Spell> spell_list;
	
	private PlayerCharacter pc;
	
	public SpellListModel(PlayerCharacter pc, List<Spell> spell_list) {
		this.pc = pc;
		this.spell_list = spell_list;
	}

	public List<Spell> getSpell_list() {
		return spell_list;
	}

	public void setSpell_list(List<Spell> spell_list) {
		this.spell_list = spell_list;
	}

	public PlayerCharacter getPc() {
		return pc;
	}
	
	public void setPc(PlayerCharacter pc) {
		this.pc = pc;
	}


	

	
	
	
}
