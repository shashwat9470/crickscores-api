package com.shashwat.crickscores.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashwat.crickscores.models.entities.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{
	Optional<Match> findByTeamsPlaying(String teamsPlaying);
}
