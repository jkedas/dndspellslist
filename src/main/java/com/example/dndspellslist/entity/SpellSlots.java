package com.example.dndspellslist.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="spell_slots")
public class SpellSlots {
	
	@Id
	@Column(name="character_id")
	private Long character_id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="character_id")
	private PlayerCharacter	pc;
	
	@ColumnDefault("0")
	private Integer level_1;
	
	@ColumnDefault("0")
	private Integer level_2;

	@ColumnDefault("0")
	private Integer level_3;
	
	@ColumnDefault("0")
	private Integer level_4;
	
	@ColumnDefault("0")
	private Integer level_5;
	
	@ColumnDefault("0")
	private Integer level_6;
	
	@ColumnDefault("0")
	private Integer level_7;
	
	@ColumnDefault("0")
	private Integer level_8;
	
	@ColumnDefault("0")
	private Integer level_9;
	
	@ColumnDefault("0")
	private Integer level_1_used;
	
	@ColumnDefault("0")
	private Integer level_2_used;

	@ColumnDefault("0")
	private Integer level_3_used;
	
	@ColumnDefault("0")
	private Integer level_4_used;
	
	@ColumnDefault("0")
	private Integer level_5_used;
	
	@ColumnDefault("0")
	private Integer level_6_used;
	
	@ColumnDefault("0")
	private Integer level_7_used;
	
	@ColumnDefault("0")
	private Integer level_8_used;
	
	@ColumnDefault("0")
	private Integer level_9_used;

	public Long getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(Long character_id) {
		this.character_id = character_id;
	}

	public PlayerCharacter getPc() {
		return pc;
	}

	public void setPc(PlayerCharacter pc) {
		this.pc = pc;
	}

	public Integer getLevel_1() {
		return level_1;
	}

	public void setLevel_1(Integer level_1) {
		this.level_1 = level_1;
	}

	public Integer getLevel_2() {
		return level_2;
	}

	public void setLevel_2(Integer level_2) {
		this.level_2 = level_2;
	}

	public Integer getLevel_3() {
		return level_3;
	}

	public void setLevel_3(Integer level_3) {
		this.level_3 = level_3;
	}

	public Integer getLevel_4() {
		return level_4;
	}

	public void setLevel_4(Integer level_4) {
		this.level_4 = level_4;
	}

	public Integer getLevel_5() {
		return level_5;
	}

	public void setLevel_5(Integer level_5) {
		this.level_5 = level_5;
	}

	public Integer getLevel_6() {
		return level_6;
	}

	public void setLevel_6(Integer level_6) {
		this.level_6 = level_6;
	}

	public Integer getLevel_7() {
		return level_7;
	}

	public void setLevel_7(Integer level_7) {
		this.level_7 = level_7;
	}

	public Integer getLevel_8() {
		return level_8;
	}

	public void setLevel_8(Integer level_8) {
		this.level_8 = level_8;
	}

	public Integer getLevel_9() {
		return level_9;
	}

	public void setLevel_9(Integer level_9) {
		this.level_9 = level_9;
	}

	public Integer getLevel_1_used() {
		return level_1_used;
	}

	public void setLevel_1_used(Integer level_1_used) {
		this.level_1_used = level_1_used;
	}

	public Integer getLevel_2_used() {
		return level_2_used;
	}

	public void setLevel_2_used(Integer level_2_used) {
		this.level_2_used = level_2_used;
	}

	public Integer getLevel_3_used() {
		return level_3_used;
	}

	public void setLevel_3_used(Integer level_3_used) {
		this.level_3_used = level_3_used;
	}

	public Integer getLevel_4_used() {
		return level_4_used;
	}

	public void setLevel_4_used(Integer level_4_used) {
		this.level_4_used = level_4_used;
	}

	public Integer getLevel_5_used() {
		return level_5_used;
	}

	public void setLevel_5_used(Integer level_5_used) {
		this.level_5_used = level_5_used;
	}

	public Integer getLevel_6_used() {
		return level_6_used;
	}

	public void setLevel_6_used(Integer level_6_used) {
		this.level_6_used = level_6_used;
	}

	public Integer getLevel_7_used() {
		return level_7_used;
	}

	public void setLevel_7_used(Integer level_7_used) {
		this.level_7_used = level_7_used;
	}

	public Integer getLevel_8_used() {
		return level_8_used;
	}

	public void setLevel_8_used(Integer level_8_used) {
		this.level_8_used = level_8_used;
	}

	public Integer getLevel_9_used() {
		return level_9_used;
	}

	public void setLevel_9_used(Integer level_9_used) {
		this.level_9_used = level_9_used;
	}
	
	
}
