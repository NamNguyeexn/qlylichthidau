package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name ="game")
public class Game {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "gameDay", nullable = false)
	private String gameDay;
	@Column(name = "gameDayTime", nullable = false)
	private String gameDayTime;
	@Column(name = "gameDayAdds", nullable = false)
	private String gameDayAdds;
	@Column(name = "SeasonId", nullable = false)
	private int seasonId;
	@Column(name = "Riderid", nullable = false)
	private int riderId;
	@Column(name = "seasonResultid", nullable = false)
	private int seasonResultId;
	@Column(name = "Userid", nullable = false)
	private int userId;
	@Transient
	private int pointRiderByG = 0;
	@Transient
	@ManyToOne
	private Season season;

	@Transient
	private Rider rider;

	@Transient
	private SeasonResult seasonResult;

	@Transient
	private User user;

	public Game() {}
	public Game(int id, String gameDay, String gameDayTime, String gameDayAdds, Season season, Rider rider, SeasonResult seasonResult, User user) {
		this.id = id;
		this.gameDay = gameDay;
		this.gameDayTime = gameDayTime;
		this.gameDayAdds = gameDayAdds;
		this.season = season;
		this.rider = rider;
		this.seasonResult = seasonResult;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameDay() {
		return gameDay;
	}

	public void setGameDay(String gameDay) {
		this.gameDay = gameDay;
	}

	public String getGameDayTime() {
		return gameDayTime;
	}

	public void setGameDayTime(String gameDayTime) {
		this.gameDayTime = gameDayTime;
	}

	public String getGameDayAdds() {
		return gameDayAdds;
	}

	public void setGameDayAdds(String gameDayAdds) {
		this.gameDayAdds = gameDayAdds;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRiders(Rider rider) {
		this.rider = rider;
	}

	public SeasonResult getSeasonResult() {
		return seasonResult;
	}

	public void setSeasonResult(SeasonResult seasonResult) {
		this.seasonResult = seasonResult;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getPointRiderByGame()
	{
		return this.pointRiderByG;
	}
	public void setPointRiderByGame(int point) {
		this.pointRiderByG = point;
	}
}
