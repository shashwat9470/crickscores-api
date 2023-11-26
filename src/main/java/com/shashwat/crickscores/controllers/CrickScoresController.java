package com.shashwat.crickscores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.entities.Match;
import com.shashwat.crickscores.services.MatchService;

@RestController
@RequestMapping(path = "/crickscores")
public class CrickScoresController {

	private MatchService matchService;
	
	public CrickScoresController(MatchService ms) {
		this.matchService = ms;
	}
	
	@GetMapping(path = "/live-scores")
	public ResponseEntity<List<Match>> liveScoresHandler(){
		List<Match> liveList = matchService.getLiveMatches();
		
		return new ResponseEntity<List<Match>>(liveList, HttpStatus.OK); 
	}
	
	@GetMapping(path = "/all-matches")
	public ResponseEntity<List<Match>> allMatchesHandler(){
		List<Match> allMatchesList = matchService.getAllMatches();
		
		return new ResponseEntity<List<Match>>(allMatchesList, HttpStatus.OK);
	}
}
