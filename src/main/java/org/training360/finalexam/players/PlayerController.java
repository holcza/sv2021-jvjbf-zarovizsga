package org.training360.finalexam.players;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlayerDTO> listPlayers(){
        return service.listPlayers();
    }

    @PostMapping
    public PlayerDTO createPlayer(@Valid @RequestBody CreatePlayerCommand command){
        return service.createPlayer(command);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer (@PathVariable("id") long id){
        service.deletePlayer(id);
    }
}
