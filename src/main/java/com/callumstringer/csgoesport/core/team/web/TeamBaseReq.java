package com.callumstringer.csgoesport.core.team.web;


import com.callumstringer.csgoesport.base.BaseRequest;

import javax.validation.constraints.NotNull;

public class TeamBaseReq extends BaseRequest {

    @NotNull
    private String teamname;

    @NotNull
    private int players;

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }
}
