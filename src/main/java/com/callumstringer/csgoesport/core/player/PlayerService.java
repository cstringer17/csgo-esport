package com.callumstringer.csgoesport.core.player;

import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import com.callumstringer.csgoesport.core.team.TeamRepo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;
    private final TeamRepo teamRepo;


    public PlayerService(PlayerRepo playerRepo, TeamRepo teamRepo) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
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


    public Player update(Player player, PlayerBaseReq req) {
        Player newPlayer = this.prepare(player,req);
        Player playerSave = playerRepo.save(newPlayer);
        return playerSave;
    }

    public void delete(Player player){
        playerRepo.delete(player);
    }


}
