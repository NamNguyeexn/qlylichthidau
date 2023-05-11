package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "raceStage")
public class RaceStage {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "RaceStageName", nullable = false)
	private String raceStageName;
	@Column(name = "raceStageMembers", nullable = false)
	private int raceStageMembers;

	public RaceStage() {
	}

	public RaceStage(int id, String raceStageName, int raceStageMembers) {
		this.id = id;
		this.raceStageName = raceStageName;
		this.raceStageMembers = raceStageMembers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaceStageName() {
		return raceStageName;
	}

	public void setRaceStageName(String raceStageName) {
		this.raceStageName = raceStageName;
	}

	public int getRaceStageMembers() {
		return raceStageMembers;
	}

	public void setRaceStageMembers(int raceStageMembers) {
		this.raceStageMembers = raceStageMembers;
	}
}
