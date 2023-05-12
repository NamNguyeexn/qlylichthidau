package com.music.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.SeasonResult;

public interface SeasonResultRepo extends JpaRepository<SeasonResult, Integer>{
	
	void deleteById(int seasonResultId);
	
	ArrayList<SeasonResult> findAll();
	
	SeasonResult findById(int seasonResultId);
	
}
