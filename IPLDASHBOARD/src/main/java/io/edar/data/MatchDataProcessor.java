package io.edar.data;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import io.edar.model.Match;
public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{
	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	  @Override
	  public Match process(final MatchInput matchInput) throws Exception {
	   Match match=new Match();
	  // match.setIngid(matchInput.getIngid());
	   match.setIngid(Long.parseLong(matchInput.getIngid()));
	   match.setCity(matchInput.getCity());
	   match.setDate(LocalDate.parse(matchInput.getDate()));
	   match.setPlayerOfMatch(matchInput.getPlayer_of_match());
	   match.setVenue(matchInput.getVenue());
	   
	   //setting team 1 and team 2 according to the innings order
	  
	   String firstInningsTeam,secondInningsTeamString;
	   if("bat".equals(matchInput.getToss_decision()))
	   
	   match.setTossWinner(matchInput.setToss_winner());
	   match.setMatchWinner(matchInput.setWinner(null));
	   return match;
	  }

}
