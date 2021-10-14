package com.callumstringer.csgoesport.core.team.web;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.PlayerService;
import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import com.callumstringer.csgoesport.core.team.Team;
import com.callumstringer.csgoesport.core.team.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Team create(@RequestBody TeamBaseReq req) {
        return teamService.create(req);
    }

    //Read
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

    //Update
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable(name = "id") Long id,
                           @RequestBody @Valid TeamBaseReq req){
        Team team = teamService.getTeam(id);
        return teamService.update(team,req);
    }

    //Delete
    @DeleteMapping()
    public String deletePlayer(@PathVariable(name = "id") Long id){
        Team team = teamService.getTeam(id);
        try{
            teamService.delete(team);
            return "Team has been successfully deleted";
        }catch(Exception e ){
            return e.toString();
        }
    }


}
