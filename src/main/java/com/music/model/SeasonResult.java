package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "seasonResult")
public class SeasonResult {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "resultRankRider", nullable = false)
	private int resultRankRider;
	@Column(name = "resultPointRider", nullable = false)
	private int resultPointRider;
	@Column(name = "resultTimeRider", nullable = false)
	private int resultTimeRider;
	@Transient
	private RaceStage raceStage;

	public SeasonResult() {
	}

	public SeasonResult(int id, int resultRankRider, int resultPointRider, int resultTimeRider, RaceStage raceStage) {
		this.id = id;
		this.resultRankRider = resultRankRider;
		this.resultPointRider = resultPointRider;
		this.resultTimeRider = resultTimeRider;
		this.raceStage = raceStage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResultRankRider() {
		return resultRankRider;
	}

	public void setResultRankRider(int resultRankRider) {
		this.resultRankRider = resultRankRider;
	}

	public int getResultPointRider() {
		return resultPointRider;
	}

	public void setResultPointRider(int resultPointRider) {
		this.resultPointRider = resultPointRider;
	}

	public int getResultTimeRider() {
		return resultTimeRider;
	}

	public void setResultTimeRider(int resultTimeRider) {
		this.resultTimeRider = resultTimeRider;
	}

	public RaceStage getRaceStage() {
		return raceStage;
	}

	public void setRaceStage(RaceStage raceStage) {
		this.raceStage = raceStage;
	}
}
