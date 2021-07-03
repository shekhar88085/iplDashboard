package io.edar.data;


import java.time.LocalDate;
//import java.time.LocalDateTime;

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
	   match.setId(Long.parseLong(matchInput.getId()));
	   match.setCity(matchInput.getCity());
	   match.setDate(LocalDate.parse(matchInput.getDate()));
	   match.setPlayerOfMatch(matchInput.getPlayer_of_match());
	   match.setVenue(matchInput.getVenue());
	   
	   //setting team 1 and team 2 according to the innings order
	  
	   String firstInningsTeam,secondInningsTeamString;
	   if("bat".equals(matchInput.getToss_decision())) {
		   firstInningsTeam=matchInput.getToss_winner();
		   secondInningsTeamString=matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();   
	   }
	  
	   else {
		   firstInningsTeam=matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
		   secondInningsTeamString=matchInput.getToss_winner();
	}
	   match.setTeam1(firstInningsTeam);
	   match.setTeam2(secondInningsTeamString);
	   match.setTossWinner(matchInput.getToss_winner());
	   //match.setMatchWinner(matchInput.setWinner(null));
	   match.setTossDecision(matchInput.getToss_decision());
	   match.setMatchWinner(matchInput.getWinner());
	   match.setResult(matchInput.getResult());
	   match.setResultMargin(matchInput.getResult_margin());
	   match.setUmpire1(matchInput.getUmpire1());
	   match.setUmpire2(matchInput.getUmpire2());
	   
	   return match;
	  }

}
















