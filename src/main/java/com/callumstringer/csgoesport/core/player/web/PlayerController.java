package com.callumstringer.csgoesport.core.player.web;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello world";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Player getPlayer(@PathVariable Long id) {

        return playerService.getPlayer(id);
    }

}
