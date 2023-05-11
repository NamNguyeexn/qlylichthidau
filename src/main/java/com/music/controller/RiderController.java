package com.music.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.ResponseObject;
import com.music.model.Rider;
import com.music.service.impl.RiderService;

@RestController
@CrossOrigin
@RequestMapping("/api/rider")
public class RiderController {
	@Autowired
	private RiderService riderService;
	@PostMapping()
	public ResponseEntity<ResponseObject<Object>> createRider(@RequestBody Rider rider){
		return ResponseEntity.ok().body(riderService.createRider(rider));
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<ResponseObject<Object>> deleteById(@PathVariable("id") int riderId){
		return ResponseEntity.ok().body(riderService.deleteById(riderId));
	}
	@GetMapping("")
	public ResponseEntity<ResponseObject<ArrayList<Rider>>> getAll() {
		return ResponseEntity.ok().body(riderService.findAll());
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<ResponseObject<Rider>> findById(@PathVariable("id") int riderId) {
		return ResponseEntity.ok().body(riderService.findById(riderId));
	}
	@GetMapping("/find/byTeam/{id}")
	public ResponseEntity<ResponseObject<ArrayList<Rider>>> findByTeamId(@PathVariable("id") int teamId){
		return ResponseEntity.ok().body(riderService.findRiderByTeamId(teamId));
	}
//	@GetMapping("/find/byRider/{id}")
//	public ResponseEntity<ResponseObject<List<Game>>> findByRiderId(@PathVariable("id") int riderId){
//		return ResponseEntity.ok().body(gameService.findByRiderId(riderId));
//	}
}
