package com.example.dndspellslist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.dndspellslist.entity.Spell;
import com.example.dndspellslist.repository.SpellRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestClientService {
	
	private final SpellRepository spellRepo;
	private RestClient client;
	public RestClientService(RestClient client, SpellRepository spellRepo) {
		this.spellRepo = spellRepo;
		this.client = client;
	}
	
	public List<Spell> fetchSpells() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String pk_list = client.get()
				.uri("https://api.open5e.com/v2/spells/?document__key__in=srd-2024&exclude=casting_options,range,range_unit,shape_size_unit,material_cost,damage_roll,document&format=json&ordering=object_pk&limit=339")
				.retrieve()
				.body(String.class);
		List<SpellJSON> spellJSON = mapper.readValue(pk_list, SpellResponse.class).results;
		List<Spell> spells = new ArrayList<>();
		for (SpellJSON spell : spellJSON) {
			Spell newSpell = spell.mapToSpell();
			spells.add(newSpell);
			
			spellRepo.save(newSpell);
		}
		
				
		return spells;
	}
	
	private static class SpellResponse {
		@SuppressWarnings("unused")
		public Integer count;
		@SuppressWarnings("unused")
		public String next = "none";
		@SuppressWarnings("unused")
		public String previous = "none";
		public List<SpellJSON> results;
	}
	private static class SpellJSON {
		@SuppressWarnings("unused")
		public String key;
		@SuppressWarnings("unused")
		public Map<String, String> school;
		@SuppressWarnings("unused")
		public List<Map<String, String>> classes;
		public String name;
		public String desc;
		public Integer level;
		public String higher_level;
		@SuppressWarnings("unused")
		public String target_type;
		public String range_text;
		public Boolean ritual;
		public String casting_time;
		@SuppressWarnings("unused")
		public String reaction_condition;
		public Boolean verbal;
		public Boolean somatic;
		public Boolean material;
		public String material_specified = "none";
		public Boolean material_consumed;
		@SuppressWarnings("unused")
		public Integer target_count;
		public String saving_throw_ability;
		@SuppressWarnings("unused")
		public Boolean attack_roll;
		public String[] damage_types;
		public String duration;
		public String shape_type;
		@SuppressWarnings("unused")
		public Integer shape_size;
		public Boolean concentration;
		
		public Spell mapToSpell() {
			Spell spell = new Spell();
			spell.setName(name);
			spell.setLevel(level);
			spell.setSchool(String.join(", ", school.get("name") ));
			spell.setCasting_time(casting_time);
			spell.setDuration(duration);
			spell.setSpell_range(range_text);
			spell.setArea(shape_type);
			spell.setAttack("");
			spell.setSaving_throw(saving_throw_ability);
			spell.setDamage_effect(String.join(", " , damage_types));
			spell.setRitual(ritual);
			spell.setConcentration(concentration);
			spell.setVerbal(verbal);
			spell.setSomatic(somatic);
			spell.setMaterial(material);
			spell.setMaterial_components(material_specified);
			spell.setMaterial_consumed(material_consumed);
			spell.setDetails(desc);
			spell.setHigher_levels(higher_level);
			
			for (Map<String, String> charClass : classes) {
				switch (charClass.get("name")) {
					case "Bard": 
						spell.setBard(true);
						break;
					case "Cleric": 
						spell.setCleric(true);
						break;
					case "Druid": 
						spell.setDruid(true);
						break;
					case "Paladin": 
						spell.setPaladin(true);
						break;
					case "Ranger": 
						spell.setRanger(true);
						break;
					case "Sorcerer": 
						spell.setSorcerer(true);
						break;
					case "Warlock": 
						spell.setWarlock(true);
						break;
					case "Wizard": 
						spell.setWizard(true);
						break;
					
					default: break;
				}
			}
			return spell;
		}
	}
	
}
