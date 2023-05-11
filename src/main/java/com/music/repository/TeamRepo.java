package com.music.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer>{
	
	void deleteById(int id);
	
	Team findById(int teamId);
	
	ArrayList<Team> findAll();
	
}