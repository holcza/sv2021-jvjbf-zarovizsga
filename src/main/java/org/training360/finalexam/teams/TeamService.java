package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.training360.finalexam.players.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamService {

    private ModelMapper modelMapper;

    private TeamRepository repo;

    private PlayerService playerService;


    public List<TeamDTO> listTeamsWithPlayers() {
        return repo.listTeamWithPlayers().stream()
                .map(m -> modelMapper.map(m, TeamDTO.class))
                .collect(Collectors.toList());

    }

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());

        repo.save(team);

        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO createAndAddPlayerToTeam(long id, CreatePlayerCommand command) {
        Team team = repo.findById(id).orElseThrow(()->new TeamNotFoundException());

        long playerId = playerService.createPlayer(command).getId();

        playerService.addPlayerToTeam(team, playerId);

        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addPlayerToTeam(long id, UpdateWithExistingPlayerCommand command) {
        Team team = repo.getById(id);

        int count = 0;

        for (Player p: team.getPlayers()){

        }

        playerService.addPlayerToTeam(team,command.getId());

        return modelMapper.map(team,TeamDTO.class);
    }
}
