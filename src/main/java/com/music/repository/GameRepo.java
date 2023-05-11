package com.music.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.Game;

public interface GameRepo extends JpaRepository<Game, Integer>{
	
	void deleteById(int gameId);
	
	ArrayList<Game> findAll();
	
	Game findById (int gameId);	
	
	Game findBySeasonResultId (int seasonResultId);
	
	ArrayList<Game> findByRiderId (int riderId);
	
//	ArrayList<Game> findBySeasonId (int seasonId);
	
//	ArrayList<Game> findByUserId (int userId);
	
}
