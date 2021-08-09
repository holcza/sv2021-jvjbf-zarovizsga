package org.training360.finalexam.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "select distinct t from Team t left join fetch t.players p")
    List<Team> listTeamWithPlayers();
}
