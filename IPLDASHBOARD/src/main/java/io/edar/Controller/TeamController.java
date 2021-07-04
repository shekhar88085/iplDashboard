package io.edar.Controller;

//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.edar.model.Team;
import io.edar.repository.MatchRepository;
import io.edar.repository.TeamRepository;

@RestController
public class TeamController {
 
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;
	 
	
	
	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		//super();
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}



	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String  teamName) {
		Team team= this.teamRepository.findByTeamName(teamName);
		//Pageable pageable=PageRequest.of(0, 4);
		team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName,4));
		return team;
	}
	}


