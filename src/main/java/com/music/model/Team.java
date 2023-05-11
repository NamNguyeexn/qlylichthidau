package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "brandTeam", nullable = false)
	private String brandTeam;
	@Column(name = "sizeTeam", nullable = false)
	private int sizeTeam;
	@Column(name = "nameTeam", nullable = false)
	private String nameTeam;
	
	public Team() {}
	public Team(int id, String brandTeam, int sizeTeam, String nameTeam) {
		this.id = id;
		this.brandTeam = brandTeam;
		this.sizeTeam = sizeTeam;
		this.nameTeam = nameTeam;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandTeam() {
		return this.brandTeam;
	}
	public void setBrandTeam(String brandTeam) {
		this.brandTeam = brandTeam;
	}
	public int getSizeTeam () {
		return this.sizeTeam;
	}
	public void setSizeTeam(int sizeTeam) {
		this.sizeTeam = sizeTeam;
	}
	public String getNameTeam() {
		return this.nameTeam;
	}
	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}
}
