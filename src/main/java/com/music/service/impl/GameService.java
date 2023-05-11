package com.music.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.Game;
import com.music.model.ResponseObject;
import com.music.model.SeasonResult;
import com.music.model.User;
import com.music.repository.GameRepo;
import com.music.repository.SeasonResultRepo;
import com.music.repository.UserRepo;
import com.music.service.IGameService;
@Service
public class GameService implements IGameService{

	@Autowired
	private GameRepo gameRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private SeasonResultRepo seasonResultRepo;
	@Override
	public ResponseObject<List<Game>> findByRiderId(int riderId) {
		try {
			Optional<List<Game>> _games = Optional.ofNullable(gameRepo.findAll());
			if(!_games.isPresent()) {
				return new ResponseObject<List<Game>>("Khong co lich thi dau nao", null);
			}
			List<Game> res = new ArrayList<>();
			for (var g : gameRepo.findAll()) {
				if (g.getRider().getId() == riderId) {
					res.add(g);
				}
			}
			if(res.size() == 0) {
				return new ResponseObject<List<Game>>("Tay dua nay khong tham gia lich thi dau nao", null);
			}
			return new ResponseObject<List<Game>>("Lay danh sach lich thi dau cua tay dua thanh cong", res);
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public ResponseObject<Object> deleteById(int gameId) {
		try {
			Optional<Game> _game = Optional.of(gameRepo.findById(gameId));
			if(!_game.isPresent()) {
				return new ResponseObject<Object>("Khong tim thay lich thi dau hop le", null);
			}
			gameRepo.deleteById(gameId);
			return new ResponseObject<Object>("Xoa thanh cong lich thi dau", null);
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public ResponseObject<List<Game>> getAll() {
		try {
			Optional<List<Game>> _games = Optional.of(gameRepo.findAll());
			if(!_games.isPresent()) {
				return new ResponseObject<List<Game>>("Khong co lich thi dau nao", null);
			}
			return new ResponseObject<List<Game>>("Lay danh sach lich thi dau thanh cong", _games.get());
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public ResponseObject<Game> findById(int gameId) {
		try {
			Optional<Game> _game = Optional.of(gameRepo.findById(gameId));
			if(!_game.isPresent()) {
				return new ResponseObject<Game>("Khong tim thay lich thi dau hop le", null);
			}
			return new ResponseObject<Game>("Lay lich thi dau thanh cong", _game.get());
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public ResponseObject<Game> findBySeasonResultId(int seasonResultId) {
		try {
			Optional<SeasonResult> _seasonResult = Optional.of(seasonResultRepo.findById(seasonResultId));
			if(!_seasonResult.isPresent()) {
				return new ResponseObject<Game>("Ma lich ket qua khong hop le", null);
			}
			Optional<Game> _game = Optional.of(gameRepo.findBySeasonResultId(_seasonResult.get().getId()));
			if(!_game.isPresent()) {
				return new ResponseObject<Game>("Khong tim thay lich thi dau hop le", null);
			}
			return new ResponseObject<Game>("Lay lich thi dau thanh cong", _game.get());
		} catch (Exception e) {
			throw e;
		}
	}
//	@Override
//	public ResponseObject<ArrayList<Game>> findBySeasonId(int seasonId) {
//		try {
//			Optional<ArrayList<Game>> _games = Optional.of(gameRepo.findBySeasonId(seasonId));
//			if(!_games.isPresent()) {
//				return new ResponseObject<ArrayList<Game>>("Khong tim thay lich thi dau hop le", null);
//			}
//			return new ResponseObject<ArrayList<Game>>("Lay danh sach lich thi dau thanh cong", _games.get());
//		} catch (Exception e) {
//			throw e;
//		}
//	}
	@Override
	public ResponseObject<List<Game>> findByUserId(int userId) {
		try {
			Optional<User> _user = userRepo.findById(userId);
			if(!_user.isPresent()) {
				return new ResponseObject<List<Game>>("Ma nhan vien khong hop le", null);
			}
			Optional<List<Game>> _games = Optional.of(gameRepo.findAll());
			if(!_games.isPresent()) {
				return new ResponseObject<List<Game>>("Khong tim thay lich thi dau hop le", null);
			}
			List<Game> res = new ArrayList<>();
			for (var g : _games.get()) {
				if(g.getUser().getId() == userId) {
					res.add(g);
				}
			}
			return new ResponseObject<List<Game>>("Lay danh sach lich thi dau thanh cong", res);
		} catch (Exception e) {
			return new ResponseObject<List<Game>>(
					e.getMessage(),
			        null
			        );
		}
	}
	@Override
	public ResponseObject<Object> createGame(Game game) {
		try {
			Optional<Game> _game = Optional.of(gameRepo.findById(game.getId()));
			if(_game.isPresent()) {
				return new ResponseObject<Object>("Lich thi dau nay da ton tai", null);
			}
			return new ResponseObject<Object>("Tao moi lich thi dau thanh cong", gameRepo.save(game));
		} catch (Exception e) {
			return new ResponseObject<Object>(
					e.getMessage(),
			        null
			        );
		}
	}
	
	
}
