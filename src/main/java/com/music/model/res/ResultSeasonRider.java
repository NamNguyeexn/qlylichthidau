package com.music.model.res;

import com.music.model.Rider;

import jakarta.persistence.Transient;

public class ResultSeasonRider {
    @Transient
    private Rider rider;
    @Transient
    private int totalPointSeason;

    public ResultSeasonRider() {
    }

    public ResultSeasonRider(Rider rider, int totalPointSeason) {
        this.rider = rider;
        this.totalPointSeason = totalPointSeason;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public int getTotalPointSeason() {
        return totalPointSeason;
    }

    public void setTotalPointSeason(int totalPointSeason) {
        this.totalPointSeason = totalPointSeason;
    }
}
