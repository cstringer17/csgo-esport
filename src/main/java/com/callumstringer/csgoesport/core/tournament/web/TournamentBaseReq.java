package com.callumstringer.csgoesport.core.tournament.web;

import com.callumstringer.csgoesport.base.BaseRequest;
import com.callumstringer.csgoesport.core.stage.Stage;
import com.callumstringer.csgoesport.core.team.Team;

import java.util.List;

public class TournamentBaseReq extends BaseRequest {


    private List<Team> teams;
    private List<Stage> stages;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }
}
