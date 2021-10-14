package com.callumstringer.csgoesport.core.team;

import com.callumstringer.csgoesport.core.team.web.TeamBaseReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }


    public Team getTeam(Long id) {
        return teamRepo.getById(id);
    }

    public List<Team> getTeams() {return teamRepo.findAll();}

    public Team create(TeamBaseReq req) {
        Team team = new Team();
        this.prepare(team, req);
        Team teamSave = teamRepo.save(team);
        return teamSave;
    }

    public Team prepare(Team team, TeamBaseReq teamBaseReq){
        team.setTeamname(teamBaseReq.getTeamname());
        return team;
    }

    public Team update(Team team, TeamBaseReq req){
        Team newTeam = this.prepare(team,req);
        Team teamSave = teamRepo.save(newTeam);
        return teamSave;
    }

    public void delete(Team team){
        teamRepo.delete(team);
    }
}
