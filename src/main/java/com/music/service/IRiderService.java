package com.music.service;

import java.util.ArrayList;

import com.music.model.ResponseObject;
import com.music.model.Rider;

public interface IRiderService {
	
	ResponseObject<ArrayList<Rider>> findAll();
	
	ResponseObject<Rider> findById(int riderId);

	ResponseObject<ArrayList<Rider>> findRiderByTeamId(int teamId);
	
}
