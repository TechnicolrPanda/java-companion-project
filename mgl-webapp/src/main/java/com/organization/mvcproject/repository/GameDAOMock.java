package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

@Repository
public class GameDAOMock {
	@SuppressWarnings("deprecation")
	private static Long gameId = new Long(0);
	@SuppressWarnings("deprecation")
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	
	
	public List<Game> retrieveAllGames() {
		return games;
	}


	public Game saveGame(Game game) {
		game.setId(++gameId);
		games.add(game);
		return game;
	}


	public void deleteGameById(long gameId) {
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getId() == gameId) {
				games.remove(i);
				
			}
		}
		
		
	}
	
	public Game updateGame(Game game) {
		if( game.getId() != null) {
			Game foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	for (int i = 0; i < games.size(); i++ ) {
					if(game.getId().equals(games.get(i).getId())) {
					    return games.set(i, game);
					}
		    	}
		    } 
		} 
		
	    game.setId(++gameId);
        games.add((Game) game);
        return game; 
	
	}
 
		
	public Game findGameById(long id) {
		for (Game game:games) {
			if(id == game.getId()) {
				return game;
			}
		}
		return null;
	}

}


