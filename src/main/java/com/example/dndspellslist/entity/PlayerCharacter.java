package com.example.dndspellslist.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="characters")
public class PlayerCharacter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long character_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany
    @JoinTable(
        name = "spell_list",
        joinColumns = @JoinColumn(name = "character_id"),
        inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private List<Spell> spells;
	
	@OneToOne(mappedBy = "pc", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private SpellSlots spell_slots;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String character_class;
	
	@Column(nullable = false)
	private Integer level;
	
	@Column(nullable = false)
	private String race;
	
	@Column
	private String alignment;
	
	@Column
	private String background;
	
	@Column(columnDefinition = "TEXT")
	private String campaign;
	
	@Column(nullable = false)
	private Integer strength;
	
	@Column(nullable = false)
	private Integer dexterity;
	
	@Column(nullable = false)
	private Integer constitution;
	
	@Column(nullable = false)
	private Integer intelligence;
	
	@Column(nullable = false)
	private Integer wisdom;
	
	@Column(nullable = false)
	private Integer charisma;
	
	@Column
	private Integer max_hp;
	
	@Column
	private Integer current_hp;
	
	@Column
	private Integer temporary_hp;
	
	@Column
	private Integer hit_dice;
	
	@Column
	private Integer current_hit_dice;
	
	@Column
	private Integer armor_class;
	
	@Column
	private Integer speed;
	
	@Column
	private Integer death_save_successes;
	
	@Column
	private Integer death_save_fails;
	
	@Column(columnDefinition = "TEXT")
	private String proficiencies_languages;
	
	@Column(columnDefinition = "TEXT")
	private String personality;
	
	@Column(columnDefinition = "TEXT")
	private String ideals;
	
	@Column(columnDefinition = "TEXT")
	private String bonds;
	
	@Column(columnDefinition = "TEXT")
	private String flaws;
	
	@Column(columnDefinition = "TEXT")
	private String features_traits;
	
	@Column(columnDefinition = "TEXT")
	private String backstory_appearance;
	
	@Column
	private Integer copper;
	
	@Column
	private Integer silver;
	
	@Column
	private Integer electrum;
	
	@Column
	private Integer gold;
	
	@Column
	private Integer platinum;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean strength_save = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean dexterity_save = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean constitution_save = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean intelligence_save = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean wisdom_save = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean charisma_save = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean acrobatics = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean animal_handling = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean arcana = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean athletics = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean deception = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean history = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean insight = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean intimidation = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean investigation = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean medicine = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean nature = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean perception = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean performance = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean persuasion = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean religion = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean sleight_of_hand = false;
	
	
	
	
	
	public String getBackstory_appearance() {
		return backstory_appearance;
	}

	public void setBackstory_appearance(String backstory_appearance) {
		this.backstory_appearance = backstory_appearance;
	}

	public SpellSlots getSpell_slots() {
		return spell_slots;
	}

	public void setSpell_slots(SpellSlots spell_slots) {
		this.spell_slots = spell_slots;
	}

	public List<Spell> getSpells() {
		return spells;
	}

	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}

	public Boolean getStrength_save() {
		return strength_save;
	}

	public void setStrength_save(Boolean strength_save) {
		this.strength_save = strength_save;
	}

	public Boolean getDexterity_save() {
		return dexterity_save;
	}

	public void setDexterity_save(Boolean dexterity_save) {
		this.dexterity_save = dexterity_save;
	}

	public Boolean getConstitution_save() {
		return constitution_save;
	}

	public void setConstitution_save(Boolean constitution_save) {
		this.constitution_save = constitution_save;
	}

	public Boolean getIntelligence_save() {
		return intelligence_save;
	}

	public void setIntelligence_save(Boolean intelligence_save) {
		this.intelligence_save = intelligence_save;
	}

	public Boolean getWisdom_save() {
		return wisdom_save;
	}

	public void setWisdom_save(Boolean wisdom_save) {
		this.wisdom_save = wisdom_save;
	}

	public Boolean getCharisma_save() {
		return charisma_save;
	}

	public void setCharisma_save(Boolean charisma_save) {
		this.charisma_save = charisma_save;
	}

	public Boolean getAcrobatics() {
		return acrobatics;
	}

	public void setAcrobatics(Boolean acrobatics) {
		this.acrobatics = acrobatics;
	}

	public Boolean getAnimal_handling() {
		return animal_handling;
	}

	public void setAnimal_handling(Boolean animal_handling) {
		this.animal_handling = animal_handling;
	}

	public Boolean getArcana() {
		return arcana;
	}

	public void setArcana(Boolean arcana) {
		this.arcana = arcana;
	}

	public Boolean getAthletics() {
		return athletics;
	}

	public void setAthletics(Boolean athletics) {
		this.athletics = athletics;
	}

	public Boolean getDeception() {
		return deception;
	}

	public void setDeception(Boolean deception) {
		this.deception = deception;
	}

	public Boolean getHistory() {
		return history;
	}

	public void setHistory(Boolean history) {
		this.history = history;
	}

	public Boolean getInsight() {
		return insight;
	}

	public void setInsight(Boolean insight) {
		this.insight = insight;
	}

	public Boolean getIntimidation() {
		return intimidation;
	}

	public void setIntimidation(Boolean intimidation) {
		this.intimidation = intimidation;
	}

	public Boolean getInvestigation() {
		return investigation;
	}

	public void setInvestigation(Boolean investigation) {
		this.investigation = investigation;
	}

	public Boolean getMedicine() {
		return medicine;
	}

	public void setMedicine(Boolean medicine) {
		this.medicine = medicine;
	}

	public Boolean getNature() {
		return nature;
	}

	public void setNature(Boolean nature) {
		this.nature = nature;
	}

	public Boolean getPerception() {
		return perception;
	}

	public void setPerception(Boolean perception) {
		this.perception = perception;
	}

	public Boolean getPerformance() {
		return performance;
	}

	public void setPerformance(Boolean performance) {
		this.performance = performance;
	}

	public Boolean getPersuasion() {
		return persuasion;
	}

	public void setPersuasion(Boolean persuasion) {
		this.persuasion = persuasion;
	}

	public Boolean getReligion() {
		return religion;
	}

	public void setReligion(Boolean religion) {
		this.religion = religion;
	}

	public Boolean getSleight_of_hand() {
		return sleight_of_hand;
	}

	public void setSleight_of_hand(Boolean sleight_of_hand) {
		this.sleight_of_hand = sleight_of_hand;
	}

	public Boolean getStealth() {
		return stealth;
	}

	public void setStealth(Boolean stealth) {
		this.stealth = stealth;
	}

	public Boolean getSurvival() {
		return survival;
	}

	public void setSurvival(Boolean survival) {
		this.survival = survival;
	}

	@Column(columnDefinition = "TINYINT")
	private Boolean stealth = false;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean survival = false;

	
	
	public long getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(long character_id) {
		this.character_id = character_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter_class() {
		return character_class;
	}

	public void setCharacter_class(String character_class) {
		this.character_class = character_class;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getCampaign() {
		return campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer deterity) {
		this.dexterity = deterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public Integer getMax_hp() {
		return max_hp;
	}

	public void setMax_hp(Integer max_hp) {
		this.max_hp = max_hp;
	}

	public Integer getCurrent_hp() {
		return current_hp;
	}

	public void setCurrent_hp(Integer current_hp) {
		this.current_hp = current_hp;
	}

	public Integer getTemporary_hp() {
		return temporary_hp;
	}

	public void setTemporary_hp(Integer temporary_hp) {
		this.temporary_hp = temporary_hp;
	}

	public Integer getHit_dice() {
		return hit_dice;
	}

	public void setHit_dice(Integer hit_dice) {
		this.hit_dice = hit_dice;
	}

	public Integer getCurrent_hit_dice() {
		return current_hit_dice;
	}

	public void setCurrent_hit_dice(Integer current_hit_dice) {
		this.current_hit_dice = current_hit_dice;
	}

	public Integer getArmor_class() {
		return armor_class;
	}

	public void setArmor_class(Integer armor_class) {
		this.armor_class = armor_class;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getDeath_save_successes() {
		return death_save_successes;
	}

	public void setDeath_save_successes(Integer death_save_successes) {
		this.death_save_successes = death_save_successes;
	}

	public Integer getDeath_save_fails() {
		return death_save_fails;
	}

	public void setDeath_save_fails(Integer death_save_fails) {
		this.death_save_fails = death_save_fails;
	}

	public String getProficiencies_languages() {
		return proficiencies_languages;
	}

	public void setProficiencies_languages(String proficiencies_languages) {
		this.proficiencies_languages = proficiencies_languages;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getIdeals() {
		return ideals;
	}

	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}

	public String getBonds() {
		return bonds;
	}

	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	public String getFlaws() {
		return flaws;
	}

	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}

	public String getFeatures_traits() {
		return features_traits;
	}

	public void setFeatures_traits(String features_traits) {
		this.features_traits = features_traits;
	}

	public Integer getCopper() {
		return copper;
	}

	public void setCopper(Integer copper) {
		this.copper = copper;
	}

	public Integer getSilver() {
		return silver;
	}

	public void setSilver(Integer silver) {
		this.silver = silver;
	}

	public Integer getElectrum() {
		return electrum;
	}

	public void setElectrum(Integer electrum) {
		this.electrum = electrum;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getPlatinum() {
		return platinum;
	}

	public void setPlatinum(Integer platinum) {
		this.platinum = platinum;
	}
	

	
	
}
