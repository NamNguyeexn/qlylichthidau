package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "rider")
public class Rider {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "nameRider", nullable = false)
	private String nameRider;
	@Column(name = "nationalRider", nullable = false)
	private String nationalRider;
	@Transient
	@ManyToOne
	private Team team;
	@Transient
	private int pointSeason = 0;
	public Rider() {}
	
	public Rider(int id, String nameRider, String nationalRider, Team team) {
		this.id = id;
		this.nameRider = nameRider;
		this.nationalRider = nationalRider;
		this.team = team;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameRider() {
		return this.nameRider;
	}
	public void setNameRider(String nameRider) {
		this.nameRider = nameRider;
	}
	public String getNationalRider() {
		return this.nationalRider;
	}
	public void setNationalRider(String nationalRider) {
		this.nationalRider = nationalRider;
	}
	public Team getTeam() {
		return this.team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getPointSeason() {
		return this.pointSeason;
	}
	public void setPointSeason(int pointSeason) {
		this.pointSeason = pointSeason;
	}
}
