package com.music.service;

import java.util.List;

import com.music.model.ResponseObject;
import com.music.model.SeasonResult;
import com.music.model.res.ResultSeasonRider;
import com.music.model.res.ResultSeasonTeam;

public interface ISeasonResultService {
	
	ResponseObject<List<ResultSeasonTeam>> rankTeamBySeason();
	
	ResponseObject<List<SeasonResult>> rankRiderByRaceStage(int raceStageId);
	
	ResponseObject<List<ResultSeasonRider>> rankRiderBySeason();

}
