package com.music.service;

import com.music.model.ResponseObject;

import java.util.List;

import com.music.model.Game;

public interface IGameService {
	
	ResponseObject<Object> createGame(Game game); 
	
	ResponseObject<Object> deleteById(int gameId);
	
	ResponseObject<List<Game>> getAll();
	
	ResponseObject<Game> findById (int gameId);	
	
	ResponseObject<Game> findBySeasonResultId (int seasonResultId);
	
//	ResponseObject<ArrayList<Game>> findBySeasonId (int seasonId);
	
	ResponseObject<List<Game>> findByUserId (int userId);
	
	ResponseObject<List<Game>> findByRiderId(int riderId);
	
}
