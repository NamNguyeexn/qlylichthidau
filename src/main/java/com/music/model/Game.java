package com.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name ="game")
public class Game {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "game_day", nullable = false)
    private String gameDay;
    @Column(name = "game_day_time", nullable = false)
    private String gameDayTime;
    @Column(name = "game_day_adds", nullable = false)
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
    private int pointRiderByGame = 0;

    public Game() {}

    public Game(int id, String gameDay, String gameDayTime, String gameDayAdds, int seasonId, int riderId, int seasonResultId, int userId, int pointRiderByGame) {
        this.id = id;
        this.gameDay = gameDay;
        this.gameDayTime = gameDayTime;
        this.gameDayAdds = gameDayAdds;
        this.seasonId = seasonId;
        this.riderId = riderId;
        this.seasonResultId = seasonResultId;
        this.userId = userId;
        this.pointRiderByGame = pointRiderByGame;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public int getSeasonResultId() {
        return seasonResultId;
    }

    public void setSeasonResultId(int seasonResultId) {
        this.seasonResultId = seasonResultId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    public int getPointRiderByGame()
    {
        return this.pointRiderByGame;
    }
    public void setPointRiderByGame(int point) {
        this.pointRiderByGame = point;
    }
}
