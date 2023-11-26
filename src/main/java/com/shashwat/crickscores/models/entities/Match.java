package com.shashwat.crickscores.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cricket_match")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchId;
	
	private String teamsPlaying;
	
	private String matchNumber;
	
	private String battingTeam;
	
	private String battingTeamScore;
	
	private String bowlingTeam;
	
	private String bowlingTeamScore;
	
	private String textLive;
	
	private String textComplete;
	
	private String matchLink;
	
	private LocalDate matchDate;
	
	@Enumerated
	private MatchStatus status;
	
	public void setMatchStatus() {
		if(this.textComplete.trim().isBlank()) this.status = MatchStatus.LIVE;
		else {
			this.status = MatchStatus.COMPLETED;
		}
	}
	
}
