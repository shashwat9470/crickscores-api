package com.shashwat.crickscores.services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.shashwat.crickscores.models.entities.Match;
import com.shashwat.crickscores.models.entities.MatchStatus;
import com.shashwat.crickscores.repositories.MatchRepository;
import com.shashwat.crickscores.services.MatchService;

@Service
public class MatchServiceImpl implements MatchService{
	
	private MatchRepository matchRepository;
	
	//constructor injection
	public MatchServiceImpl(MatchRepository mr){
		this.matchRepository = mr;
	}

	@Override
	public List<Match> getLiveMatches() {
		// TODO Auto-generated method stub
		List<Match> matchList = new ArrayList<>();
		
		try {
			String url = "https://www.cricbuzz.com/cricket-match/live-scores";
			Document document = Jsoup.connect(url).get();
			
			Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-tms-itm");
			
			for(Element element : liveScoreElements) {
				String teamsPlayingString = element.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
				String matchNumberVenueString = element.select("span.text-gray").text();
				
				Elements battingElement = element.select("div.cb-hmscg-bat-txt");
				String battingTeamString = battingElement.select("div.cb-hmscg-tm-nm").text();
				String battingTeamScoreString = battingElement.select("div.cb-hmscg-tm-nm+div").text();
				
				Elements bowlingElement = element.select("div.cb-hmscg-bwl-txt");
				String bowlingTeamString = bowlingElement.select("div.cb-hmscg-tm-nm").text();
				String bowlingTeamScoreString = bowlingElement.select("div.cb-hmscg-tm-nm+div").text();
				
				String textLiveString = element.select("div.cb-text-live").text();
				String textCompleteString = element.select("div.cb-text-complete").text();
				
				String matchLinkString = element.select("h3.cb-lv-scr-mtch-hdr > a").attr("href").toString();
				
				Match match = Match.builder()
						.teamsPlaying(teamsPlayingString)
						.matchNumber(matchNumberVenueString)
						.battingTeam(battingTeamString)
						.battingTeamScore(battingTeamScoreString)
						.bowlingTeam(bowlingTeamString)
						.bowlingTeamScore(bowlingTeamScoreString)
						.textLive(textLiveString)
						.textComplete(textCompleteString)
						.matchLink(matchLinkString)
						.matchDate(LocalDate.now())
						.build();
				
				match.setMatchStatus();
				updateMatch(match);
				
				if(match.getStatus().equals(MatchStatus.LIVE)) {
					matchList.add(match);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matchList;
	}
	
	private void updateMatch(Match m) {
		Match match = this.matchRepository.findByTeamsPlaying(m.getTeamsPlaying()).orElse(null);
		
		if(match != null) {
			m.setMatchId(match.getMatchId());
			this.matchRepository.save(m);
		}
		else {
			this.matchRepository.save(m);
		}
	}

	@Override
	public List<Match> getAllMatches() {
		// TODO Auto-generated method stub
		List<Match> allMatchesList = this.matchRepository.findAll();
		return allMatchesList;
	}

}
