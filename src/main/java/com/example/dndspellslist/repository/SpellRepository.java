package com.example.dndspellslist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dndspellslist.entity.Spell;

public interface SpellRepository extends JpaRepository<Spell, Long>{

	@Query("SELECT s FROM Spell s WHERE s.name = ?1")
	public Spell findByName(String name);
	
	@Query("SELECT s FROM Spell s WHERE s.level = ?1")
	public List<Spell> findByLevel(Integer level);
	
	@Query("SELECT s FROM Spell s WHERE s.spell_id = ?1")
	public Spell findById(long spell_id);
	
	/*
	@Query("SELECT s FROM Spell LEFT INNER JOIN spell_list ON Spell.spell_id = spell_list.spell_id WHERE spell_list.character_id = ?1")
	public List<Spell> getSpellList(Integer character_id);
	*/
}
