package com.music.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.ResponseObject;
import com.music.model.Rider;
import com.music.model.Team;
import com.music.repository.RiderRepo;
import com.music.repository.TeamRepo;
import com.music.service.IRiderService;
@Service
public class RiderService implements IRiderService{
	@Autowired
	private RiderRepo riderRepo;
	@Autowired
	private TeamRepo teamRepo;
	
	@Override
	public ResponseObject<ArrayList<Rider>> findRiderByTeamId(int teamId) {
		try {
			Optional<Team> _team =  Optional.of(teamRepo.findById(teamId));
			if(!_team.isPresent()) {
				return new ResponseObject<ArrayList<Rider>>("Ma doi khong phu hop", null);
			} 
			ArrayList<Rider> riders = riderRepo.findAll();
			ArrayList<Rider> res = new ArrayList<>();
			for (var r : riders) {
				if (r.getTeam().getId() == teamId) {
					res.add(r);
				}
			}
			if(res.size() == 0) {
				return new ResponseObject<ArrayList<Rider>>("Doi nay khong co thanh vien nao", null);
			}
			return new ResponseObject<ArrayList<Rider>>("Lay thanh vien doi thanh cong", res);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ResponseObject<ArrayList<Rider>> findAll() {
		try {
			Optional<ArrayList<Rider>> _riders = Optional.of(riderRepo.findAll());
			if (!_riders.isPresent()) {
				return new ResponseObject<ArrayList<Rider>>("Khong tim thay tay dua", null);
			}
			return new ResponseObject<ArrayList<Rider>>("Xoa tay dua thanh cong", _riders.get());
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ResponseObject<Rider> findById(int riderId) {
		try {
			Optional<Rider> _rider = Optional.ofNullable(riderRepo.findById(riderId));
			if (!_rider.isPresent()) {
				return new ResponseObject<Rider>("Khong tim thay tay dua", null);
			}
			return new ResponseObject<Rider>("Xoa tay dua thanh cong", _rider.get());
		} catch (Exception e) {
			throw e;
		}
	}

}
