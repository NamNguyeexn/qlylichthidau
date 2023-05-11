package com.music.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.RaceStage;

public interface RaceStageRepo extends JpaRepository<RaceStage, Integer> {
	
	ArrayList<RaceStage> findAll();
	
	RaceStage findById(int id);
	
}
