package com.shashwat.crickscores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.dtos.PlayerRankingDto;
import com.shashwat.crickscores.services.RankingsService;

@RestController
@RequestMapping(path = "/crickscores/rankings")
public class RankingsController {
	
	private RankingsService rankingsService;
	
	public RankingsController(RankingsService rs) {
		this.rankingsService = rs;
	}
	
	@GetMapping(path = "/men/batting/test")
	public ResponseEntity<List<PlayerRankingDto>> menBattingTestRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBattingTestRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/batting/odi")
	public ResponseEntity<List<PlayerRankingDto>> menBattingOdiRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBattingOdiRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/batting/t20")
	public ResponseEntity<List<PlayerRankingDto>> menBattingT20Ranking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBattingT20Rankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/bowling/test")
	public ResponseEntity<List<PlayerRankingDto>> menBowlingTestRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBowlingTestRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/bowling/odi")
	public ResponseEntity<List<PlayerRankingDto>> menBowlingOdiRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBowlingOdiRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/bowling/t20")
	public ResponseEntity<List<PlayerRankingDto>> menBowlingT20Ranking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenBowlingT20Rankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/all-rounder/test")
	public ResponseEntity<List<PlayerRankingDto>> menAllRounderTestRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenAllRoundersTestRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/all-rounder/odi")
	public ResponseEntity<List<PlayerRankingDto>> menAllRounderOdiRanking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenAllRoundersOdiRankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/men/all-rounder/t20")
	public ResponseEntity<List<PlayerRankingDto>> menAllRounderT20Ranking(){
		List<PlayerRankingDto> list = this.rankingsService.getMenAllRoundersT20Rankings();
		return new ResponseEntity<List<PlayerRankingDto>>(list, HttpStatus.OK);
	}

}
