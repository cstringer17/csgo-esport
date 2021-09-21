package com.callumstringer.csgoesport.core.player.web;

import javax.validation.constraints.NotNull;

public class PlayerTeamReq {
    @NotNull
    private Long team;

    @NotNull
    private  Long player;

    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long username) {
        this.player = username;
    }
}
