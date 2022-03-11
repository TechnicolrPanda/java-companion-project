package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.repository.GameDAOMock;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAOMock gameDAOMock;
	
	@Override
	public List<Game> retrieveAllGames() {
		return gameDAOMock.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDAOMock.saveGame(game);
	}

	@Override
	public Boolean deleteGame(long gameId) {
		return gameDAOMock.deleteGameById(gameId);
	}

	@Override
	public Game updateGame(Game game) {
		return gameDAOMock.updateGame(game);
	}


}