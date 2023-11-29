package com.shashwat.crickscores.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.dtos.MatchDto;
import com.shashwat.crickscores.services.MatchService;

@RestController
@RequestMapping(path = "/crickscores")
public class CrickScoresController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrickScoresController.class);
	private MatchService matchService;
	
	public CrickScoresController(MatchService ms) {
		this.matchService = ms;
	}
	
	@GetMapping(path = "/live-scores")
	public ResponseEntity<List<MatchDto>> liveScoresHandler(){
		List<MatchDto> liveList = matchService.getLiveMatches();
		LOGGER.info("Live matches : " + liveList.size());
		return new ResponseEntity<List<MatchDto>>(liveList, HttpStatus.OK); 
	}
	
	@GetMapping(path = "/completed")
	public ResponseEntity<List<MatchDto>> completedMatchesHandler(){
		List<MatchDto> completedMatchesList = matchService.getCompletedMatches();
		LOGGER.info("completed matches : " + completedMatchesList.size());
		return new ResponseEntity<List<MatchDto>>(completedMatchesList, HttpStatus.OK);
	}
	
	@GetMapping(path = "/all-matches")
	public ResponseEntity<List<MatchDto>> allMatchesHandler(){
		List<MatchDto> allMatchesList = matchService.getAllMatches();
		LOGGER.info("all matches : " + allMatchesList.size());
		return new ResponseEntity<List<MatchDto>>(allMatchesList, HttpStatus.OK);
	}
}
