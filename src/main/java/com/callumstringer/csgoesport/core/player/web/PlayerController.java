package com.callumstringer.csgoesport.core.player.web;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Player create(@RequestBody  PlayerBaseReq req) {
        return playerService.create(req);
    }

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    //Update
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable(name = "id") Long id,
                               @RequestBody @Valid PlayerBaseReq req){
        Player player = playerService.getPlayer(id);
        return playerService.update(player, req);
    }

    //Delete
    @DeleteMapping
    public String deletePlayer(@PathVariable(name = "id") Long id){
        Player player = playerService.getPlayer(id);
        try {
            playerService.delete(player);
            return "Player has successfully deleted";
        }catch(Exception e){
            return e.toString();
        }

    }

}
