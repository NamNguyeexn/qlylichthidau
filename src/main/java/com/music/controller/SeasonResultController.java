package com.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.ResponseObject;
import com.music.model.SeasonResult;
import com.music.model.res.ResultSeasonRider;
import com.music.model.res.ResultSeasonTeam;
import com.music.service.impl.SeasonResultService;

@RestController
@CrossOrigin
@RequestMapping("/api/result")
public class SeasonResultController {
	@Autowired
	private SeasonResultService seasonResultService;
	@RequestMapping("/rank/rider/byRaceStage")
	public ResponseEntity<ResponseObject<List<SeasonResult>>> rankRaceStage(@PathVariable("id") int raceStageId){
		return ResponseEntity.ok().body(seasonResultService.rankRiderByRaceStage(raceStageId));
	}
	@RequestMapping("rank/rider/bySeason")
	public ResponseEntity<ResponseObject<List<ResultSeasonRider>>> rankRiderSeason(){
		return ResponseEntity.ok().body(seasonResultService.rankRiderBySeason());
	}
	@RequestMapping("rank/team/bySeason")
	public ResponseEntity<ResponseObject<List<ResultSeasonTeam>>> rankTeamSeason(){
		return ResponseEntity.ok().body(seasonResultService.rankTeamBySeason());
	}
}
