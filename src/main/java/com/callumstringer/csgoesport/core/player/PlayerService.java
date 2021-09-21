package com.callumstringer.csgoesport.core.player;

import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import com.callumstringer.csgoesport.core.player.web.PlayerTeamReq;
import com.callumstringer.csgoesport.core.team.Team;
import com.callumstringer.csgoesport.core.team.TeamRepo;
import com.callumstringer.csgoesport.core.team.TeamService;
import org.springframework.stereotype.Service;

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

    public Player addTeamToPlayer(PlayerTeamReq req) {
        Player player = playerRepo.getById(req.getPlayer());
        Team team = teamRepo.getById(req.getTeam());
        player.addTeam(team);
        Player playerSave = playerRepo.save(player);
        return playerSave;

    }
}
