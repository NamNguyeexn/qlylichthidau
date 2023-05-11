package com.music.model.res;

import com.music.model.Team;

import jakarta.persistence.Transient;

public class ResultSeasonTeam {
    @Transient
    private Team team;
    @Transient
    private int pointTeam;

    public ResultSeasonTeam() {
    }

    public ResultSeasonTeam(Team team, int pointTeam) {
        this.team = team;
        this.pointTeam = pointTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getPointTeam() {
        return pointTeam;
    }

    public void setPointTeam(int pointTeam) {
        this.pointTeam = pointTeam;
    }
}
