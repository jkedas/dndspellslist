package com.example.dndspellslist.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dndspellslist.entity.PlayerCharacter;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {
	
	@Query("SELECT c FROM PlayerCharacter c WHERE c.character_id = ?1")
	public PlayerCharacter findById(long character_id);
	
	@Query("SELECT c FROM PlayerCharacter c WHERE c.user.id = ?1")
	public List<PlayerCharacter> findByUser(long user_id);

	@Query("SELECT c FROM PlayerCharacter c WHERE c.name = ?1")
	public PlayerCharacter findByName(Integer name);
	
	
}
