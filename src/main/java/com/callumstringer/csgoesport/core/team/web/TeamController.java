package com.callumstringer.csgoesport.core.team.web;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.PlayerService;
import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import com.callumstringer.csgoesport.core.team.Team;
import com.callumstringer.csgoesport.core.team.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Team create(@RequestBody TeamBaseReq req) {
        return teamService.create(req);
    }

    @GetMapping("")
    @ResponseBody
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

}
