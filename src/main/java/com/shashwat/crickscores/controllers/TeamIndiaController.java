package com.shashwat.crickscores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.crickscores.models.dtos.ResultDto;
import com.shashwat.crickscores.models.dtos.ScheduleDto;
import com.shashwat.crickscores.services.TeamIndiaService;

@RestController
@RequestMapping(path = "/crickscores")
public class TeamIndiaController {

	private TeamIndiaService teamIndiaService;
	
	public TeamIndiaController(TeamIndiaService tis) {
		this.teamIndiaService = tis;
	}
	
	@GetMapping(path = "/ind-schedule")
	public ResponseEntity<List<ScheduleDto>> getSchedule(){
		List<ScheduleDto> list = this.teamIndiaService.getScheduleForTeamIndia();
		return new ResponseEntity<List<ScheduleDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/ind-results")
	public ResponseEntity<List<ResultDto>> getResults(){
		List<ResultDto> list = this.teamIndiaService.getResultsTeamIndia();
		return new ResponseEntity<List<ResultDto>>(list, HttpStatus.OK);
	}
}
