package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.training360.finalexam.teams.Team;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerService {

    private ModelMapper modelMapper;

    private PlayerRepository repo;


    public List<PlayerDTO> listPlayers() {

        return repo.findAll().stream()
                .map(m -> modelMapper.map(m, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());

        repo.save(player);

        return modelMapper.map(player, PlayerDTO.class);
    }

    public void deletePlayer(long id) {

        repo.deleteById(id);
    }

    public PlayerDTO findPlayerById(long id){

        return modelMapper.map(repo.findById(id).get(),PlayerDTO.class);
    }

    public void addPlayerToTeam(Team team, long id) {
        team.addPlayer(repo.getById(id));
    }
}
