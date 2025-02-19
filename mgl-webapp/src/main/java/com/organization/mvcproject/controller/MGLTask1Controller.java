package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.model.Review;
import com.organization.mvcproject.service.GameService;
import com.organization.mvcproject.service.GameServiceImpl;

@Controller
public class MGLTask1Controller {

	@Autowired
	private GameServiceImpl gameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
	
		return new ModelAndView("reviewCreatePage", "command", new Review());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
	
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		
		return new ModelAndView("gamesPage", "command", new Game());
	}	
	
	@RequestMapping(value = "/game/allGames", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@RequestMapping(value = "/game/newGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		if(game.getId() != null) {
			gameService.updateGame(game);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/game/deleteGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteGame(@RequestBody Game game){
		gameService.deleteGame(game.getId());
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	
	
}