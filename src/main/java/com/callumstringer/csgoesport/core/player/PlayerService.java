package com.callumstringer.csgoesport.core.player;

import ch.qos.logback.classic.PatternLayout;
import com.callumstringer.csgoesport.core.player.converter.PlayerToPlayerViewConverter;
import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import com.callumstringer.csgoesport.core.player.web.PlayerView;
import com.callumstringer.csgoesport.core.team.TeamRepo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;
    private final TeamRepo teamRepo;
    private final PlayerToPlayerViewConverter playerToPlayerViewConverter;


    public PlayerService(PlayerRepo playerRepo, TeamRepo teamRepo, PlayerToPlayerViewConverter playerToPlayerViewConverter) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
        this.playerToPlayerViewConverter = playerToPlayerViewConverter;
    }

    public PlayerView getPlayerView(Long id) {
        return playerToPlayerViewConverter.convert(playerRepo.getById(id));
    }

    public Player getPlayer(Long id){
        return playerRepo.getById(id);
    }

    public List<PlayerView> getPlayers() {
        List<PlayerView> players = new ArrayList<>();
        playerRepo.findAll().forEach( player ->{
            PlayerView toAdd = playerToPlayerViewConverter.convert(player);
            players.add(toAdd);
        });
        return players;
    }

    public PlayerView create(PlayerBaseReq req) {
        Player player = new Player();
        this.prepare(player, req);
        Player playerSave = playerRepo.save(player);
        return playerToPlayerViewConverter.convert(playerSave);
    }

    public Player prepare(Player player, PlayerBaseReq playerBaseReq){
        player.setName(playerBaseReq.getName());
        player.setUsername(playerBaseReq.getUsername());
        return player;
    }


    public PlayerView update(Player player, PlayerBaseReq req) {
        Player newPlayer = this.prepare(player,req);
        Player playerSave = playerRepo.save(newPlayer);
        return playerToPlayerViewConverter.convert(player);
    }

    public void delete(Player player){
        playerRepo.delete(player);
    }


}
