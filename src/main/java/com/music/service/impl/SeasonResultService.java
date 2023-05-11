package com.music.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.Game;
import com.music.model.ResponseObject;
import com.music.model.Rider;
import com.music.model.SeasonResult;
import com.music.model.Team;
import com.music.model.res.ResultSeasonRider;
import com.music.model.res.ResultSeasonTeam;
import com.music.model.res.ResultStageRider;
import com.music.repository.GameRepo;
import com.music.repository.RiderRepo;
import com.music.repository.SeasonResultRepo;
import com.music.repository.TeamRepo;
import com.music.service.ISeasonResultService;

@Service
public class SeasonResultService implements ISeasonResultService{

	@Autowired
	private SeasonResultRepo seasonResultRepo;
	@Autowired
	private TeamRepo teamRepo;
	@Autowired
	private RiderRepo riderRepo;
	@Autowired
	private GameRepo gameRepo;
	private List<SeasonResult> riderByRaceStageId(int raceStageId){
		List<SeasonResult> res = new ArrayList<>();
		Optional<List<SeasonResult>> _seasonResults = Optional.of(seasonResultRepo.findAll());
		Optional<List<Game>> _games = Optional.of(gameRepo.findAll());
		for (var s : _seasonResults.get()) {
			if (s.getRaceStage().getId() == raceStageId) {
				for (var g : _games.get()) {
					if (g.getSeasonResult().getId() == s.getId()) {
						res.add(s);
					}
				}
			}
		}
		return res;
	}
	private Boolean solveResultByRaceStageId(int raceStageId) {
		try {
			
			List<SeasonResult> riderByRaceStageId = riderByRaceStageId(raceStageId);
			
			if(riderByRaceStageId.size() == 0) return false;
			Collections.sort(riderByRaceStageId, new Comparator<SeasonResult>() {

				@Override
				public int compare(SeasonResult o1, SeasonResult o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.getResultRankRider(), o2.getResultRankRider());
				}
					
			});
			int coun = 1;
			for (var i : riderByRaceStageId) {
				i.setResultRankRider(coun);
				i.setResultPointRider(coun);
				Game g = gameRepo.findBySeasonResultId(i.getId());
				g.setPointRiderByGame(coun);
				coun += 1;
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	// ket qua ca mua giai
	public ResponseObject<List<ResultSeasonTeam>> rankTeamBySeason() {
		try {
			Optional<List<Team>> _teams = Optional.of(teamRepo.findAll());
			Optional<List<SeasonResult>> _seasonResults = Optional.of(seasonResultRepo.findAll());
			Optional<List<Rider>> _riders = Optional.of(riderRepo.findAll());
			List<SeasonResult> res = new ArrayList<>();
			for ()
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public ResponseObject<List<SeasonResult>> rankRiderByRaceStage(int raceStageId) {
		try {
			List<SeasonResult> res = riderByRaceStageId(raceStageId);
			Boolean b = solveResultByRaceStageId(raceStageId);
			if(!b) {
				return new ResponseObject<List<SeasonResult>>("Ma doi nhap vao khong hop le", null);
			}
			return new ResponseObject<List<SeasonResult>>("Lay bang xep hang theo chang dua thanh cong", res);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	// ket qua theo mua giai, 
	public ResponseObject<List<ResultSeasonRider>> rankRiderBySeason() {
		List<Rider> riders = riderRepo.findAll();
		List<SeasonResult> seasonResults = seasonResultRepo.findAll();
		List<Game> games = gameRepo.findAll();
		List<SeasonResult> lastRes = new ArrayList<>();
		for (var s : seasonResults) {
			for (var r : riders) {
				for (var g : games) {
					if (g.getRider().getId() == r.getId() && g.getSeasonResult().getId() == s.getId()) {
						int sum = r.getPointSeason() + g.getPointRiderByGame();
						r.setPointSeason(sum);
						lastRes.add(s);
					}
				}
			}
		}
		Collections.sort();
		
	}

}
