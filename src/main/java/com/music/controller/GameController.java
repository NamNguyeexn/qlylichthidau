package com.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.Game;
import com.music.model.ResponseObject;
import com.music.service.impl.GameService;

@RestController
@CrossOrigin
@RequestMapping("/api/game")
public class GameController {
	@Autowired
	private GameService gameService;
	@PostMapping()
	public ResponseEntity<ResponseObject<Object>> createGame(@RequestBody Game game){
		return ResponseEntity.ok().body(gameService.createGame(game));
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<ResponseObject<Object>> deleteById(@PathVariable("id") int gameId){
		return ResponseEntity.ok().body(gameService.deleteById(gameId));
	}
	@GetMapping("")
	public ResponseEntity<ResponseObject<List<Game>>> getAll() {
		return ResponseEntity.ok().body(gameService.getAll());
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<ResponseObject<Game>> findByGameId(@PathVariable("id") int gameid) {
		return ResponseEntity.ok().body(gameService.findById(gameid));
	}
	@GetMapping("/find/bySeasonResult/{id}")
	public ResponseEntity<ResponseObject<Game>> findBySeasonResultId(@PathVariable("id") int seasonResultId){
		return ResponseEntity.ok().body(gameService.findBySeasonResultId(seasonResultId));
	}
	@GetMapping("/find/byRider/{id}")
	public ResponseEntity<ResponseObject<List<Game>>> findByRiderId(@PathVariable("id") int riderId){
		return ResponseEntity.ok().body(gameService.findByRiderId(riderId));
	}
}
