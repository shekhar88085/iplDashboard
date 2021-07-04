package io.edar.repository;

import org.springframework.data.repository.CrudRepository;

import io.edar.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
	
	Team findByTeamName(String teamName);
}
