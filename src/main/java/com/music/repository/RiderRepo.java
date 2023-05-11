package com.music.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.Rider;

public interface RiderRepo extends JpaRepository<Rider, Integer>{
	
	void deleteById(int riderid);
	
	ArrayList<Rider> findAll();
	
	Rider findById(int riderId);

}
