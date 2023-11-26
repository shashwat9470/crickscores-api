package com.shashwat.crickscores.services;

import java.util.List;

import com.shashwat.crickscores.models.entities.Match;

public interface MatchService {

	List<Match> getLiveMatches();
	
	List<Match> getAllMatches();
}
