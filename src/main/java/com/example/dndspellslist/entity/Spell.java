package com.example.dndspellslist.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="spell")
public class Spell {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long spell_id;
	
	@ManyToMany(mappedBy = "spells")
    private List<PlayerCharacter> characters;
	
	@Column(nullable = false, unique = true, length=100)
	private String name;
	
	@Column(nullable = false)
	private Integer level;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String school;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String casting_time;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String duration;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String spell_range;
	
	@Column(columnDefinition = "TEXT")
	private String area;
	
	@Column(columnDefinition = "TEXT")
	private String attack;
	
	@Column(columnDefinition = "TEXT")
	private String saving_throw;
	
	@Column(columnDefinition = "TEXT")
	private String damage_effect;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean ritual = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean concentration = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean verbal = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean somatic = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean material = false;
    
	@Column(columnDefinition = "TEXT")
	private String material_components;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean material_consumed = false;
	
	@Column(nullable=false, columnDefinition = "TEXT")
	private String details;
	
	@Column(columnDefinition = "TEXT")
	private String higher_levels;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean	bard = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean cleric = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean druid = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean paladin = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean ranger = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean sorcerer = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean warlock = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean wizard = false;
	
	//getters and setters
	public long getSpell_id() {
		return spell_id;
	}

	public void setSpell_id(long id) {
		this.spell_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCasting_time() {
		return casting_time;
	}

	public void setCasting_time(String casting_time) {
		this.casting_time = casting_time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSpell_range() {
		return spell_range;
	}

	public void setSpell_range(String spell_range) {
		this.spell_range = spell_range;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getSaving_throw() {
		return saving_throw;
	}

	public void setSaving_throw(String saving_throw) {
		this.saving_throw = saving_throw;
	}

	public String getDamage_effect() {
		return damage_effect;
	}

	public void setDamage_effect(String damage_effect) {
		this.damage_effect = damage_effect;
	}

	public Boolean getRitual() {
		return ritual;
	}

	public void setRitual(Boolean ritual) {
		this.ritual = ritual;
	}

	public Boolean getConcentration() {
		return concentration;
	}

	public void setConcentration(Boolean concentration) {
		this.concentration = concentration;
	}

	public Boolean getVerbal() {
		return verbal;
	}

	public void setVerbal(Boolean verbal) {
		this.verbal = verbal;
	}

	public Boolean getSomatic() {
		return somatic;
	}

	public void setSomatic(Boolean somatic) {
		this.somatic = somatic;
	}

	public Boolean getMaterial() {
		return material;
	}

	public void setMaterial(Boolean material) {
		this.material = material;
	}

	public String getMaterial_components() {
		return material_components;
	}
	
	public void setMaterial_components(String material_components) {
		this.material_components = material_components;
	}

	public Boolean getMaterial_consumed() {
		return material_consumed;
	}

	public void setMaterial_consumed(Boolean material_consumed) {
		this.material_consumed = material_consumed;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<PlayerCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(List<PlayerCharacter> characters) {
		this.characters = characters;
	}

	public String getHigher_levels() {
		return higher_levels;
	}

	public void setHigher_levels(String higher_levels) {
		this.higher_levels = higher_levels;
	}

	public Boolean getBard() {
		return bard;
	}

	public void setBard(Boolean bard) {
		this.bard = bard;
	}

	public Boolean getCleric() {
		return cleric;
	}

	public void setCleric(Boolean cleric) {
		this.cleric = cleric;
	}

	public Boolean getDruid() {
		return druid;
	}

	public void setDruid(Boolean druid) {
		this.druid = druid;
	}

	public Boolean getPaladin() {
		return paladin;
	}

	public void setPaladin(Boolean paladin) {
		this.paladin = paladin;
	}

	public Boolean getRanger() {
		return ranger;
	}

	public void setRanger(Boolean ranger) {
		this.ranger = ranger;
	}

	public Boolean getSorcerer() {
		return sorcerer;
	}

	public void setSorcerer(Boolean sorcerer) {
		this.sorcerer = sorcerer;
	}

	public Boolean getWarlock() {
		return warlock;
	}

	public void setWarlock(Boolean warlock) {
		this.warlock = warlock;
	}

	public Boolean getWizard() {
		return wizard;
	}

	public void setWizard(Boolean wizard) {
		this.wizard = wizard;
	}

	
	
}
