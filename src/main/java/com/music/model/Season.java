package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "season")
public class Season {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "nameSeason", nullable = false)
	private String nameSeason;
	@Column(name = "beginSeasonTime", nullable = false)
	private String beginSeasonTime;
	@Column(name = "endSeasonTime", nullable = false)
	private String endSeasonTime;
	
	public Season() {}
	public Season(int id, String nameSeason, String beginSeasonTime, String endSeasonTime) {
		this.id = id;
		this.nameSeason = nameSeason;
		this.beginSeasonTime = beginSeasonTime;
		this.endSeasonTime = endSeasonTime;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameSeason() {
		return this.nameSeason;
	}
	public void setNameSeason(String nameSeason) {
		this.nameSeason = nameSeason;
	}
	
	public String getBeginSeasonTime() {
		return this.beginSeasonTime;
	}
	public void setBeginSeasonTime(String beginSeasonTime) {
		this.beginSeasonTime = beginSeasonTime;
	}
	
	public String getEndSeasonTime() {
		return this.endSeasonTime;
	}
	public void setEndSeasonTime(String endSeasonTime) {
		this.endSeasonTime = endSeasonTime;
	}
}
