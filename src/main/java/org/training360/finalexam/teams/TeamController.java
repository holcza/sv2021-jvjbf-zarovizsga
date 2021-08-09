package org.training360.finalexam.teams;

import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.UpdateWithExistingPlayerCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeamDTO> listTeamsWithPlayers(){
        return service.listTeamsWithPlayers();
    }

    @PostMapping
    public TeamDTO createTeam(@Valid @RequestBody CreateTeamCommand command){
        return service.createTeam(command);
    }

    @PostMapping("/{id}/players")
    public TeamDTO createAndAddPlayerToTeam(@PathVariable("id") long id, @Valid @RequestBody CreatePlayerCommand command){
        return service.createAndAddPlayerToTeam(id, command);
    }

    @PutMapping("/{id}/players")
    public TeamDTO addPlayerToTeam(@PathVariable("id") long id, @Valid @RequestBody UpdateWithExistingPlayerCommand command) {
        return service.addPlayerToTeam(id, command);
    }
}
