package com.music.repository;

import java.util.ArrayList;

import com.music.model.SeasonResult;

public interface SeasonResultRepo {
	
	void deleteById(int seasonResultId);
	
	ArrayList<SeasonResult> findAll();
	
	SeasonResult findById(int seasonResultId);
	
	
}
