package com.callumstringer.csgoesport.core.player;

import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;


    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player getPlayer(Long id) {
        return playerRepo.getById(id);
    }

    public List<Player> getPlayers() {return playerRepo.findAll();}

    public Player create(PlayerBaseReq req) {
        Player player = new Player();
        this.prepare(player, req);
        Player playerSave = playerRepo.save(player);
        return playerSave;
    }

    public Player prepare(Player player, PlayerBaseReq playerBaseReq){
        player.setName(playerBaseReq.getName());
        player.setUsername(playerBaseReq.getUsername());
        return player;
    }
}
