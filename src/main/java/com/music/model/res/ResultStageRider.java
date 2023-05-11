package com.music.model.res;

import com.music.model.RaceStage;
import com.music.model.Rider;

import jakarta.persistence.Transient;

public class ResultStageRider {
    @Transient
    private Rider rider;
    @Transient
    private int totalPointStage;
    @Transient
    private RaceStage raceStage;
    public ResultStageRider() {
    }

    public ResultStageRider(Rider rider, int totalPointStage, RaceStage raceStage) {
        this.rider = rider;
        this.totalPointStage = totalPointStage;
        this.raceStage = raceStage;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public int getTotalPointStage() {
        return totalPointStage;
    }

    public void setTotalPointStage(int totalPointStage) {
        this.totalPointStage = totalPointStage;
    }
    public RaceStage getRaceStage() {
    	return this.raceStage;
    }
    public void setRaceStage(RaceStage raceStage) {
    	this.raceStage = raceStage;
    }
}
